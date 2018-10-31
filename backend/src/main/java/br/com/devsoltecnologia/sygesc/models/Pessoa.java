package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.devsoltecnologia.sygesc.models.enums.Genero;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String rg;
	private String ufRg;
	private Date dataNascimento;
	private Genero genero;
	private String email;

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Pessoa() {
		super();
		this.endereco = new Endereco();
	}

	public Pessoa(String nome, String cpf, String rg, String ufRg, Date dataNascimento, Genero genero, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.ufRg = ufRg;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUfRg() {
		return ufRg;
	}

	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
