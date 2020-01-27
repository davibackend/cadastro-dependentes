package com.compasso.challenge.register.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.challenge.register.domain.model.Dependent;
import com.compasso.challenge.register.domain.service.DependentService;

@RestController
@RequestMapping("/dependents")
public class DependentController extends GenericController<Dependent> {

	@Autowired
	private DependentService dependenteService;

	@GetMapping("/clients/{id}")
	public List<Dependent> buscarDependentes(@PathVariable Long id) {
		return dependenteService.findClientsDependents(id);
	}

}
