package br.com.querojobs.exception;

import org.springframework.http.HttpStatus;

public class TokenExpiredException extends ApiException {
	private static final long serialVersionUID = 1L;

	public TokenExpiredException() {
		super(HttpStatus.UNAUTHORIZED, "Sua sessão expirou. Você precisa logar novamente.");
	}
	
}
