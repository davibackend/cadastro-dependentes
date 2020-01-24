package com.compasso.desafio;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.desafio.cadastro.domain.model.BaseObject;

import lombok.Getter;
import lombok.Setter;

public class GenericMock<E extends BaseObject> {

	@Autowired
	protected EntityManager entityManager;

	@Getter
	@Setter
	protected E entity;

	public void entityManagerPersist() {
		entityManager.persist(entity);
		entityManager.flush();
	}

}
