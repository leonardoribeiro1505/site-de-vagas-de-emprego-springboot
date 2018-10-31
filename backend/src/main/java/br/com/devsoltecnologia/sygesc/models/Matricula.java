/*package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.devsoltecnologia.sygesc.models.enums.Status;

@Entity
public class Matricula extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// @EmbeddedId
	// private MatriculaPK id = new MatriculaPK();

	private Double mensalidade;
	private Integer numeroMatricula;
	private Double desconto;
	private Integer prestacoes;
	private Status status;
	private Date data;

	public Matricula() {
	}

	public Matricula(Aluno aluno, Turma turma, Double mensalidade, Integer numeroMatricula, Double desconto,
			Integer prestacoes, Status status, Date data) {
		super();
		// id.setAluno(aluno);
		// id.setTurma(turma);
		this.mensalidade = mensalidade;
		this.numeroMatricula = numeroMatricula;
		this.desconto = desconto;
		this.prestacoes = prestacoes;
		this.status = status;
		this.data = data;
	}

	// public Aluno getAluno() {
	// return id.getAluno();
	// }
	//
	// public Turma getTurma() {
	// return id.getTurma();
	// }
	//
	// public MatriculaPK getId() {
	// return id;
	// }
	//
	// public void setId(MatriculaPK id) {
	// this.id = id;
	// }

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getPrestacoes() {
		return prestacoes;
	}

	public void setPrestacoes(Integer prestacoes) {
		this.prestacoes = prestacoes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
*/