package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Disciplina extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer cargaHoraria;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "disciplinas")
	private List<Curso> cursos = new ArrayList<>();

	public Disciplina() {
	}

	public Disciplina(String nome, Integer cargaHoraria) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
