package com.compasso.desafio.cadastro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.compasso.desafio.cadastro.domain.model.BaseObject;
import com.compasso.desafio.cadastro.domain.service.GenericService;

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

	//TODO validacao igual aos services.
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public E cadastrarCliente(@RequestBody E dadosCliente) {
		return service.insert(dadosCliente);
	}

	@PutMapping("/atualizar/{id}")
	public E atualizar(@RequestBody E dadosCliente, @PathVariable Long id) {
		return service.update(dadosCliente, id);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}

}
