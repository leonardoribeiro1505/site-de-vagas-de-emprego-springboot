package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Cargo extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	@ManyToMany(mappedBy = "cargos")
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Cargo() {
	}

	public Cargo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
