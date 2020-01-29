package com.compasso.challenge.register.domain.exception;

public class EmailCpfAlreadyExistsException extends EntityAlreadyExistsException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_EMAIL_DUPLICATED = "Entity with this email {%s} already exist.";
	private static final String MSG_CPF_DUPLICATED = "Entity with this cpf: {%s} already exist.";

	public EmailCpfAlreadyExistsException(String menssagem, boolean isSuper) {
		super(menssagem);
	}

	public EmailCpfAlreadyExistsException(String email) {
		this(String.format(MSG_EMAIL_DUPLICATED, email), true);
	}

	public EmailCpfAlreadyExistsException(Long cpf) {
		this(String.format(MSG_CPF_DUPLICATED, cpf), true);
	}

}
