package com.compasso.challenge.register.domain.repository;

import java.util.List;
import java.util.Optional;

import com.compasso.challenge.register.domain.model.Dependent;

public interface DependentRepository extends GenericRepository<Dependent> {

	public Optional<Dependent> findByCpf(Long cpf);

	public Optional<Dependent> findByEmail(String email);

	public Optional<List<Dependent>> findByIdClient(Long idCliente);

}
