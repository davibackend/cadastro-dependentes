package com.compasso.desafio.cadastro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.compasso.desafio.cadastro.domain.model.Cliente;
import com.compasso.desafio.cadastro.domain.model.Dependente;
import com.compasso.desafio.cadastro.domain.repository.ClienteRepository;
import com.compasso.desafio.cadastro.domain.repository.DependenteRepository;

@Service
public class ClienteService extends GenericService<Cliente> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DependenteRepository dependenteRepository;

	@Override
	public Cliente insert(Cliente entity) {
		validarDadosEntidade(entity);
		return super.insert(entity);
	}

	@Override
	public void delete(Long id) {
		findObjectById(id);
		List<Dependente> dependentes = dependenteRepository.findByIdCliente(id);
		if (dependentes.isEmpty()) {
			super.delete(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"Existem dependentes relacionados a este cliente");
		}
	}

	public void deletar(Long id) {

	}

	public Optional<Cliente> findByCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	public Optional<Cliente> findByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}

	private void validarDadosEntidade(Cliente entity) {
		if (findByCpf(entity.getCpf()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente com este CPF.");
		}
		if (findByEmail(entity.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente com este email.");
		}
	}

}
