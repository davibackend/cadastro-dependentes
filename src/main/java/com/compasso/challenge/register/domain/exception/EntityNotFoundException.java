package com.compasso.challenge.register.domain.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_ENTITY_ID_NOT_FOUND = "entity with id %d not found";

	public EntityNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public EntityNotFoundException(Long id) {
		this(String.format(MSG_ENTITY_ID_NOT_FOUND, id));
	}

}
