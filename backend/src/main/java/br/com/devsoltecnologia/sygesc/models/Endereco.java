package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cep;

	@OneToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	@OneToOne(mappedBy = "endereco")
	private Pessoa pessoa;

	@OneToOne(mappedBy = "endereco")
	private Instituicao instituicao;

	public Endereco() {
	}

	public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cep, Pessoa pessoa,
			Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.pessoa = pessoa;
		this.setCidade(cidade);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
