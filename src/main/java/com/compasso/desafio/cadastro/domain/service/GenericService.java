package com.compasso.desafio.cadastro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.compasso.desafio.cadastro.domain.model.BaseObject;
import com.compasso.desafio.cadastro.domain.repository.GenericRepository;

public abstract class GenericService<E extends BaseObject> {

	@Autowired
	public GenericRepository<E> genericRepository;

	public List<E> findAll() {
		return genericRepository.findAll();
	}

	public E findObjectById(Long id) {
		Optional<E> result = genericRepository.findById(id);
		if (!result.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe um objeto com este id");
		}
		return result.get();
	}

	public E insert(E entity) {
		return genericRepository.save(entity);
	}

	public E update(E entity, Long id) {
		E obj = findObjectById(id);
		obj = entity;
		obj.setId(id);
		return genericRepository.save(obj);
	}

	//TODO tratar exceção de cliente com relacionamento @OneToMany cascade hibernate.
	public void delete(Long id) {
		genericRepository.deleteById(id);
	}

}
