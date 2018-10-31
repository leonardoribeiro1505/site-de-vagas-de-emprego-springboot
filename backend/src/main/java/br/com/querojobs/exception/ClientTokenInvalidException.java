package br.com.querojobs.exception;

import org.springframework.http.HttpStatus;

public class ClientTokenInvalidException extends ApiException {

	private static final long serialVersionUID = -6266330192941464572L;

	public ClientTokenInvalidException() {
		super(HttpStatus.FORBIDDEN, "Token do usuário não autorizado");
	}
}