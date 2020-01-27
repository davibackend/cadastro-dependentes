package com.compasso.challenge.register.domain.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.challenge.register.domain.model.BaseObject;

import lombok.Data;

@Data
public class GenericMock<E extends BaseObject> {

	@Autowired
	protected EntityManager entityManager;

	protected E entity;

	public void entityManagerPersist() {
		entityManager.persist(entity);
		entityManager.flush();
	}

}
