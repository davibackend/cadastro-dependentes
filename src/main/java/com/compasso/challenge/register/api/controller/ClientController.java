package com.compasso.challenge.register.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.challenge.register.domain.model.Client;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/clients")
@Api(value = "test")
public class ClientController extends GenericController<Client> {

}
