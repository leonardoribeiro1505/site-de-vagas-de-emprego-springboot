package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Responsavel extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	private Double renda;
	private Date data;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "responsaveis")
	private List<Aluno> dependentes = new ArrayList<>();

	public Responsavel() {
		super();
		this.pessoa = new Pessoa();
	}

	public Responsavel(Double renda, Date data) {
		super();
		this.renda = renda;
		this.data = data;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Aluno> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Aluno> dependentes) {
		this.dependentes = dependentes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
