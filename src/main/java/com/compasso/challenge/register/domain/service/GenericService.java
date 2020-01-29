package com.compasso.challenge.register.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.challenge.register.domain.exception.EntityNotFoundException;
import com.compasso.challenge.register.domain.model.BaseObject;
import com.compasso.challenge.register.domain.repository.GenericRepository;

public abstract class GenericService<E extends BaseObject> {

	public static final String MSG_ENTITY_EMAIL_DUPLICATED = "entity with email %s has already exists";
	public static final String MSG_ENTITY_CPF_DUPLICATED = "entity with cpf %d has already exists";

	@Autowired
	public GenericRepository<E> genericRepository;

	public List<E> findAll() {
		return genericRepository.findAll();
	}

	public E findObjectById(Long id) {
		return genericRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public E insert(E entity) {
		return genericRepository.save(entity);
	}

	public E update(E entity, Long id) {
		entity.setId(genericRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)).getId());
		return genericRepository.save(entity);
	}

	// TODO melhorar exceção de cliente com relacionamento @OneToMany cascade
	// hibernate.
	public void delete(Long id) {
		genericRepository.deleteById(id);
	}

}
