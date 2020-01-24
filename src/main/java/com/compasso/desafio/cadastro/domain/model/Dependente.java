package com.compasso.desafio.cadastro.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Dependente extends BaseObject {

	private static final long serialVersionUID = 1L;

	public Dependente() {
	}

	public Dependente(String nome, Long cpf, String email, Date dataCadastro, Long idCliente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.idCliente = idCliente;
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

	@Column(name = "fk_cliente")
	@Getter
	@Setter
	private Long idCliente;

}
