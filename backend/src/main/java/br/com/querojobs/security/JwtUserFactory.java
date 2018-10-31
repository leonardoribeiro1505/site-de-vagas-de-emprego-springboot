package br.com.querojobs.security;

import org.springframework.security.core.Authentication;

import br.com.querojobs.models.auth.Usuario;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static UserSS create(Usuario user) {
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getPerfis());
	}

	public static UserSS create(Authentication authentication) {
		return (UserSS) authentication.getPrincipal();
	}

}
