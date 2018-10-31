package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NotaBimestre extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double nota;
	private Date data;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	public NotaBimestre() {
	}

	public NotaBimestre(String nome, Double nota, Date data, Turma turma) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.data = data;
		this.turma = turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
