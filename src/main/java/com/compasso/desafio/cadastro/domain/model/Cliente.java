package com.compasso.desafio.cadastro.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Cliente extends BaseObject {

	private static final long serialVersionUID = 1L;

	public Cliente() {
	}

	public Cliente(String nome, Long cpf, String email, Date dataCadastro) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	@Column
	@Getter
	@Setter
	private String nome;

	@Column
	@Getter
	@Setter
	private Long cpf;

	@Column
	@Getter
	@Setter
	private String email;

	@Column(name = "data_cadastro")
	@Getter
	@Setter
	private Date dataCadastro;

}
