package com.compasso.desafio.cadastro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.compasso.desafio.cadastro.domain.model.Dependente;
import com.compasso.desafio.cadastro.domain.repository.DependenteRepository;

@Service
public class DependenteService extends GenericService<Dependente> {

	@Autowired
	private DependenteRepository dependenteRepository;

	public List<Dependente> buscarDependentesCliente(Long id) {
		return dependenteRepository.findByIdCliente(id);
	}

	@Override
	public Dependente insert(Dependente entity) {
		validarDadosEntidade(entity);
		return super.insert(entity);
	}

	public Optional<Dependente> findByCpf(Long cpf) {
		return dependenteRepository.findByCpf(cpf);
	}

	public Optional<Dependente> findByEmail(String email) {
		return dependenteRepository.findByEmail(email);
	}

	private void validarDadosEntidade(Dependente entity) {
		if (findByCpf(entity.getCpf()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente com este CPF.");
		}
		if (findByEmail(entity.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente com este email.");
		}
	}

}
