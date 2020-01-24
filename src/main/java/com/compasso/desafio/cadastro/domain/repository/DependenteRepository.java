package com.compasso.desafio.cadastro.domain.repository;

import java.util.List;
import java.util.Optional;

import com.compasso.desafio.cadastro.domain.model.Dependente;

public interface DependenteRepository extends GenericRepository<Dependente> {

	public Optional<Dependente> findByCpf(Long cpf);

	public Optional<Dependente> findByEmail(String email);

	public List<Dependente> findByIdCliente(Long idCliente);

}
