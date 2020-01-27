package com.compasso.challenge.register.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.challenge.register.domain.model.Client;
import com.compasso.challenge.register.domain.service.ClientService;

public class ClientRepositoryTest extends GenericRepositoryTest<Client> {

	@Autowired
	ClientService clientService;

	@Test
	@DisplayName("Teste de busca de cliente por CPF")
	public void findClientByCpfTest() {
		mockEntity();
		entityManagerPersist();
		Client client = clientService.findByCpf(getEntity().getCpf());
		assertThat(client).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de cliente por email")
	public void findClienteByEmailTest() {
		mockEntity();
		entityManagerPersist();
		Client client = clientService.findByEmail(getEntity().getEmail());
		assertThat(client).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste cadastro novo cliente")
	public void insertTest() {
		entityManager.clear();
		mockEntity();
		clientService.insert(entity);
		assertThat(entityManager.contains(entity)).isTrue();
	}

	@Test
	@DisplayName("Teste excluir cliente")
	public void deleteTest() {
		mockEntity();
		entityManagerPersist();
		clientService.delete(entity.getId());
		assertThat(entityManager.contains(entity)).isFalse();
	}

	@Test
	@DisplayName("Teste alterar cliente")
	public void updateTest() {
		mockEntity();
		entityManagerPersist();
		Client cloneClient = clientDTO(entity);
		Client clientUpdated = updateClientDTO(entity);
		clientService.update(clientUpdated, entity.getId());
		assertThat(cloneClient).isNotEqualTo(entity);
	}

	private void mockEntity() {
		entity = new Client();
	}

	private Client updateClientDTO(Client cliente) {
		cliente.setName("nomeClienteAlterado");
		cliente.setCpf(55555555555l);
		cliente.setEmail("emailalterado@hotmail.com");
		cliente.setRegistrationDate(new Date());
		return cliente;
	}

	private Client clientDTO(Client entity) {
		Client cliente = new Client();
		cliente.setName(entity.getName());
		cliente.setCpf(entity.getCpf());
		cliente.setEmail(entity.getEmail());
		cliente.setRegistrationDate(entity.getRegistrationDate());
		return cliente;
	}

}
