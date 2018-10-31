package br.com.querojobs.exception;

import org.springframework.http.HttpStatus;

public class ClientTokenNotFoundException extends ApiException {

	private static final long serialVersionUID = 2472035179836987288L;

	public ClientTokenNotFoundException() {
		super(HttpStatus.UNAUTHORIZED, "Token do usuário não informado");
	}
}
