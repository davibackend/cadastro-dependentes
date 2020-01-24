package com.compasso.desafio.cadastro.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.desafio.cadastro.domain.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends GenericController<Cliente> {

}
