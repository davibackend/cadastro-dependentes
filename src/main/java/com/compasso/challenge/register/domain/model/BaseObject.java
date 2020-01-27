package com.compasso.challenge.register.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank
	private String name;

	@Column
	@NotNull
	private Long cpf;

	@Column
	@NotBlank
	private String email;

	@Column(name = "registration_date")
	@NotNull
	private Date registrationDate;

}
