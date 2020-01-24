package com.compasso.desafio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.desafio.cadastro.domain.model.Cliente;
import com.compasso.desafio.cadastro.domain.service.ClienteService;

public class ClienteRepositoryTest extends GenericRepositoryTest<Cliente> {

	@Autowired
	ClienteService clienteService;

	@Test
	@DisplayName("Teste de busca de cliente por CPF")
	public void buscarClientePorCpfTest() {
		mockEntity();
		entityManagerPersist();
		Optional<Cliente> found = clienteService.findByCpf(getEntity().getCpf());
		assertThat(found.get()).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de cliente por email")
	public void buscarClientePorEmailTest() {
		mockEntity();
		entityManagerPersist();
		Optional<Cliente> found = clienteService.findByEmail(getEntity().getEmail());
		assertThat(found.get()).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste cadastro novo cliente")
	public void insertTest() {
		entityManager.clear();
		mockEntity();
		clienteService.insert(entity);
		assertThat(entityManager.contains(entity)).isTrue();
	}

	@Test
	@DisplayName("Teste excluir cliente")
	public void deleteTest() {
		mockEntity();
		entityManagerPersist();
		clienteService.delete(entity.getId());
		assertThat(entityManager.contains(entity)).isFalse();
	}

	@Test
	@DisplayName("Teste alterar cliente")
	public void updateTest() {
		mockEntity();
		entityManagerPersist();
		Cliente cloneCliente = clienteDTO(entity);
		Cliente clienteAlterado = alterarClienteDTO(entity);
		clienteService.update(clienteAlterado, entity.getId());
		assertThat(cloneCliente).isNotEqualTo(entity);
	}

	private void mockEntity() {
		entity = new Cliente("nomecliente", 11122233345l, "emailcliente@hotmail.com", new Date());
	}

	private Cliente alterarClienteDTO(Cliente cliente) {
		cliente.setNome("nomeClienteAlterado");
		cliente.setCpf(55555555555l);
		cliente.setEmail("emailalterado@hotmail.com");
		cliente.setDataCadastro(new Date());
		return cliente;
	}

	private Cliente clienteDTO(Cliente entity) {
		Cliente cliente = new Cliente();
		cliente.setNome(entity.getNome());
		cliente.setCpf(entity.getCpf());
		cliente.setEmail(entity.getEmail());
		cliente.setDataCadastro(entity.getDataCadastro());
		return cliente;
	}

}
