package br.com.querojobs.exception;

import org.springframework.http.HttpStatus;

public class TokenUsernameException extends ApiException {
	private static final long serialVersionUID = 1L;

	public TokenUsernameException() {
		super(HttpStatus.UNAUTHORIZED, "O usuário da sua sessão foi alterado. Você precisa logar novamente.");
	}
}