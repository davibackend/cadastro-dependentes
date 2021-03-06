package com.compasso.challenge.register.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.compasso.challenge.register.domain.model.BaseObject;
import com.compasso.challenge.register.domain.service.GenericService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(value = "*")
@Api(value = "Dependent Registration REST API")
@EnableSwagger2
public class GenericController<E extends BaseObject> {

	@Autowired
	private GenericService<E> service;

	@GetMapping
	@ApiOperation("Return list of entity")
	public List<E> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation("Return entity or id")
	public E findById(@PathVariable Long id) {
		return service.findObjectById(id);
	}

	@PostMapping
	@ApiOperation("Register entity")
	@ResponseStatus(HttpStatus.CREATED)
	public E insert(@Valid @RequestBody E entity) {
		return service.insert(entity);
	}

	@PutMapping("/{id}")
	@ApiOperation("Update entity")
	public E update(@RequestBody E entity, @PathVariable Long id) {
		return service.update(entity, id);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete entity")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
