package com.compasso.challenge.register.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.compasso.challenge.register.domain.exception.EmailCpfAlreadyExistsException;
import com.compasso.challenge.register.domain.exception.EmailCpfNotFoundException;
import com.compasso.challenge.register.domain.model.Client;
import com.compasso.challenge.register.domain.model.Dependent;
import com.compasso.challenge.register.domain.repository.ClientRepository;
import com.compasso.challenge.register.domain.repository.DependentRepository;

@Service
public class ClientService extends GenericService<Client> {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private DependentRepository dependentRepository;

	public Client findByEmail(String email) {
		return clientRepository.findByEmail(email).orElseThrow(() -> new EmailCpfNotFoundException(email));
	}

	public Client findByCpf(Long cpf) {
		return clientRepository.findByCpf(cpf).orElseThrow(() -> new EmailCpfNotFoundException(cpf));
	}

	@Override
	public Client insert(Client entity) {
		isValidRequestToInsert(entity);
		return super.insert(entity);
	}

	@Override
	public void delete(Long id) {
		Optional<List<Dependent>> dependents = dependentRepository.findByIdClient(id);
		if (dependents.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"There are dependents linked to this client, it was not possible to delete");
		} else {
			super.delete(id);
		}
	}

	// TODO refactory reuso no DependentService -> verificar possibilidade do uso de
	// @ControllerAdvice
	private void isValidRequestToInsert(Client entity) {
		if (clientRepository.findByEmail(entity.getEmail()).isPresent()) {
			throw new EmailCpfAlreadyExistsException(entity.getEmail());
		} else if (clientRepository.findByCpf(entity.getCpf()).isPresent()) {
			throw new EmailCpfAlreadyExistsException(entity.getCpf());
		}
	}

}
