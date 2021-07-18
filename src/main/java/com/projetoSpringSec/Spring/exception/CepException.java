package com.projetoSpringSec.Spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CepException extends AuthenticationException{

	private static final long serialVersionUID = 1L;

	public CepException(String msg) {
		super(msg);
	}

}
