package com.compasso.challenge.register.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.challenge.register.domain.model.Client;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(value = "API REST of register dependents")
@RequestMapping("/clients")
public class ClientController extends GenericController<Client> {

}
