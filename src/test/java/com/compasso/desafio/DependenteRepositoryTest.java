package com.compasso.desafio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.desafio.cadastro.domain.model.Cliente;
import com.compasso.desafio.cadastro.domain.model.Dependente;
import com.compasso.desafio.cadastro.domain.service.ClienteService;
import com.compasso.desafio.cadastro.domain.service.DependenteService;

public class DependenteRepositoryTest extends GenericRepositoryTest<Dependente> {

	@Autowired
	DependenteService dependenteService;

	@Autowired
	ClienteService clienteService;

	private void mockDependente(Long idCliente) {
		entity = new Dependente("nomecliente", 11122233345l, "emailcliente@hotmail.com", new Date(), idCliente);
	}

	private Cliente getMockCliente() {
		Cliente cliente = new Cliente("teste", 11325468536L, "teste", new Date());
		return cliente;
	}

	private void persistirDependente() {
		Cliente cliente = getMockCliente();
		entityManager.clear();
		entityManager.persist(cliente);
		mockDependente(cliente.getId());
		entityManagerPersist();
	}

	@Test
	@DisplayName("Teste de busca de cliente por CPF")
	public void buscarDependentePorCpfTest() {
		persistirDependente();
		Optional<Dependente> found = dependenteService.findByCpf(getEntity().getCpf());
		assertThat(found.get()).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de cliente por email")
	public void buscarDependentePorEmailTest() {
		persistirDependente();
		Optional<Dependente> found = dependenteService.findByEmail(getEntity().getEmail());
		assertThat(found.get()).isEqualTo(getEntity());
	}

	@Test
	@DisplayName("Teste de busca de dependentes por id cliente")
	public void buscarDependentesCliente() {
		Cliente cliente = getMockCliente();
		entityManager.clear();
		entityManager.persist(cliente);
		mockDependente(cliente.getId());
		entityManagerPersist();
		List<Dependente> dependentes = dependenteService.buscarDependentesCliente(getEntity().getIdCliente());

		assertThat(dependentes.isEmpty()).isFalse();
		for (Dependente dependente : dependentes) {
			assertThat(dependente.getIdCliente()).isEqualTo(cliente.getId());
		}
	}

	@Test
	@DisplayName("Teste excluir dependente")
	public void deleteTest() {
		persistirDependente();
		dependenteService.delete(getEntity().getId());
		assertThat(entityManager.contains(getEntity())).isFalse();
	}
}
