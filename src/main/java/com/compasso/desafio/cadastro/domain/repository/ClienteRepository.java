package com.compasso.desafio.cadastro.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.compasso.desafio.cadastro.domain.model.Cliente;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente> {

	public Optional<Cliente> findByCpf(Long cpf);

	public Optional<Cliente> findByEmail(String email);

}
