package com.compasso.challenge.register.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Dependent extends BaseObject {

	private static final long serialVersionUID = 1L;

	@Column(name = "fk_client")
	@Getter
	@Setter
	private Long idClient;

}
