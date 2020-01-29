package com.compasso.challenge.register.domain.exception;

public class EntityAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_ENTITY_ID_DUPLICATED = "entity with id %d already exists";

	public EntityAlreadyExistsException(String menssagem) {
		super(menssagem);
	}

	public EntityAlreadyExistsException(Long id) {
		this(String.format(MSG_ENTITY_ID_DUPLICATED, id));
	}

}
