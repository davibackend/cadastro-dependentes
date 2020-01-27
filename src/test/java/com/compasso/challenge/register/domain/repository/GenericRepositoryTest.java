package com.compasso.challenge.register.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.compasso.challenge.register.domain.model.BaseObject;
import com.compasso.challenge.register.domain.repository.GenericRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "com.compasso.desafio.")
public class GenericRepositoryTest<E extends BaseObject> extends GenericMock<E> {

	@Autowired
	private GenericRepository<E> genericRepository;

	@Test
	@DisplayName("Teste de componentes")
	public void testComponents() {
		assertThat(genericRepository).isNotNull();
		assertThat(entityManager).isNotNull();
	}

	@Test
	@DisplayName("Buscando todos da identidade")
	public void findAllTest() {
		assertThat(genericRepository.findAll()).isNotNull();
	}

}
