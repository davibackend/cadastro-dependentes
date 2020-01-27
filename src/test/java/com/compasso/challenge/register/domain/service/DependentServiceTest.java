package com.compasso.challenge.register.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.challenge.register.domain.model.Client;
import com.compasso.challenge.register.domain.model.Dependent;
import com.compasso.challenge.register.domain.repository.GenericRepositoryTest;
import com.compasso.challenge.register.domain.service.ClientService;
import com.compasso.challenge.register.domain.service.DependentService;

public class DependentServiceTest extends GenericRepositoryTest<Dependent> {

	@Autowired
	DependentService dependentService;

	@Autowired
	ClientService clientService;

	private void mockDependent(Long idCliente) {
		entity = new Dependent();
	}

	private Client getMockClient() {
		Client client = new Client();
		return client;
	}

	private void persistDependent() {
		Client cliente = getMockClient();
		entityManager.clear();
		entityManager.persist(cliente);
		mockDependent(cliente.getId());
		entityManagerPersist();
	}

	@Test
	@DisplayName("Teste de busca de cliente por CPF")
	public void findDependentByCpfTest() {
		persistDependent();
		Dependent dependente = dependentService.findByCpf(getEntity().getCpf());
		assertThat(dependente).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de cliente por email")
	public void findDependentByEmailTest() {
		persistDependent();
		Dependent dependent = dependentService.findByEmail(getEntity().getEmail());
		assertThat(dependent).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de dependentes por id cliente")
	public void findDependentsByClientTest() {
		Client cliente = getMockClient();
		entityManager.clear();
		entityManager.persist(cliente);
		mockDependent(cliente.getId());
		entityManagerPersist();
		List<Dependent> dependentes = dependentService.findClientsDependents(getEntity().getIdClient());

		assertThat(dependentes.isEmpty()).isFalse();
		for (Dependent dependente : dependentes) {
			assertThat(dependente.getIdClient()).isEqualTo(cliente.getId());
		}
	}

	@Test
	@DisplayName("Teste excluir dependente")
	public void deleteTest() {
		persistDependent();
		dependentService.delete(getEntity().getId());
		assertThat(entityManager.contains(getEntity())).isFalse();
	}
}
