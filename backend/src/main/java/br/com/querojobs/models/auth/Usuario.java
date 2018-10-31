package br.com.querojobs.models.auth;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.querojobs.models.AbstractModel;
import br.com.querojobs.models.Authority;
import br.com.querojobs.models.enums.Perfil;

@Document(collection = "usuarios")
public class Usuario extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;

	@Indexed(unique = true)
	private String email;

	private String senha;
	private String telefone;
	private String website;
	private Boolean enabled = Boolean.TRUE;
	
	private List<Authority> authorities;
	
	private Set<String> perfis = new HashSet<>();

	public Usuario() {
		addPerfil(Perfil.USUARIO);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.USUARIO).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getValue());
	}

}
