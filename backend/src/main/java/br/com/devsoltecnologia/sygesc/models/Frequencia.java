package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Frequencia extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String presente;
	private String bimestre;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "FREQUENCIA_TURMA", joinColumns = @JoinColumn(name =
	 * "frequencia_id"), inverseJoinColumns = @JoinColumn(name = "id.") ) private
	 * List<MatriculaPK> matriculas = new ArrayList<>();
	 */

	public Frequencia() {
	}

	public Frequencia(String presente, String bimestre, Turma turma) {
		super();
		this.presente = presente;
		this.bimestre = bimestre;
		this.turma = turma;
	}

	public String getPresente() {
		return presente;
	}

	public void setPresente(String presente) {
		this.presente = presente;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
