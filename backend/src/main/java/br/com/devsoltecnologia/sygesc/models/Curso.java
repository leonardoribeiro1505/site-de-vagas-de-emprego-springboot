package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cargaHoraria;
	private Integer numeroVagas;
	private Double mensalidade;

	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "CURSO_DISCIPLINA", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	public Curso() {
	}

	public Curso(String nome, String cargaHoraria, Integer numeroVagas, Double mensalidade) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.numeroVagas = numeroVagas;
		this.mensalidade = mensalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(Integer numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
