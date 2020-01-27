package com.compasso.challenge.register.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.compasso.challenge.register.domain.model.BaseObject;
import com.compasso.challenge.register.domain.service.GenericService;

public class GenericController<E extends BaseObject> {

	@Autowired
	private GenericService<E> service;

	@GetMapping
	public List<E> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public E findById(@PathVariable Long id) {
		return service.findObjectById(id);
	}

	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public E insert(@Valid @RequestBody E entity) {
		return service.insert(entity);
	}

	@PutMapping("/update/{id}")
	public E update(@RequestBody E entity, @PathVariable Long id) {
		return service.update(entity, id);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
