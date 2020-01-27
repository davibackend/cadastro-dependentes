package com.compasso.challenge.register.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.compasso.challenge.register.domain.model.Client;

@Repository
public interface ClientRepository extends GenericRepository<Client> {

	public Optional<Client> findByCpf(Long cpf);

	public Optional<Client> findByEmail(String email);

}
