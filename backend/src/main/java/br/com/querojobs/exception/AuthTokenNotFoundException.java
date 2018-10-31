package br.com.querojobs.exception;

import org.springframework.http.HttpStatus;

public class AuthTokenNotFoundException extends ApiException {

	private static final long serialVersionUID = 2472035179836987288L;

	public AuthTokenNotFoundException() {
		super(HttpStatus.UNAUTHORIZED, "Token de autorização não informado");
	}
}