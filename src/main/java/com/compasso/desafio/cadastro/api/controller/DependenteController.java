package com.compasso.desafio.cadastro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.desafio.cadastro.domain.model.Dependente;
import com.compasso.desafio.cadastro.domain.service.DependenteService;

@RestController
@RequestMapping("/dependente")
public class DependenteController extends GenericController<Dependente> {

	@Autowired
	private DependenteService dependenteService;

	@GetMapping("/cliente/{id}")
	public List<Dependente> buscarDependentes(@PathVariable Long id) {
		return dependenteService.buscarDependentesCliente(id);
	}

}
