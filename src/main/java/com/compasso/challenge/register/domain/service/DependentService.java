package com.compasso.challenge.register.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.compasso.challenge.register.domain.exception.EmailCpfNotFoundException;
import com.compasso.challenge.register.domain.exception.EntityNotFoundException;
import com.compasso.challenge.register.domain.model.Dependent;
import com.compasso.challenge.register.domain.repository.DependentRepository;

@Service
public class DependentService extends GenericService<Dependent> {

	@Autowired
	private DependentRepository dependentRepository;

	public List<Dependent> findClientsDependents(Long id) {
		return dependentRepository.findByIdClient(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Dependent findByCpf(Long cpf) {
		return dependentRepository.findByCpf(cpf).orElseThrow(() -> new EmailCpfNotFoundException(cpf));
	}

	public Dependent findByEmail(String email) {
		return dependentRepository.findByEmail(email).orElseThrow(() -> new EmailCpfNotFoundException(email));
	}

	@Override
	public Dependent insert(Dependent entity) {
		isValidRequestToInsert(entity);
		return super.insert(entity);
	}

	// TODO refactory reuso no ClientService -> verificar possibilidade do uso de
	// @ControllerAdvice
	private void isValidRequestToInsert(Dependent entity) {
		if (dependentRepository.findByEmail(entity.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity with this email already exist.");
		} else if (dependentRepository.findByCpf(entity.getCpf()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity with this cpf already exist.");
		}
	}

}
