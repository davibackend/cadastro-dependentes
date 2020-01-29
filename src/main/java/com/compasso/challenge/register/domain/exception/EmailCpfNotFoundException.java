package com.compasso.challenge.register.domain.exception;

public class EmailCpfNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_ENTITY_EMAIL_NOT_FOUND = "entity with email %s not found";
	private static final String MSG_ENTITY_CPF_NOT_FOUND = "entity with cpf %d not found";

	public EmailCpfNotFoundException(String menssagem, boolean isSuper) {
		super(menssagem);
	}

	public EmailCpfNotFoundException(String email) {
		this(String.format(MSG_ENTITY_EMAIL_NOT_FOUND, email), true);
	}

	public EmailCpfNotFoundException(Long cpf) {
		this(String.format(MSG_ENTITY_CPF_NOT_FOUND, cpf), true);
	}

}
