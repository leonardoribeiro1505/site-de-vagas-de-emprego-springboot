package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.devsoltecnologia.sygesc.models.enums.Turno;

@Entity
public class Turma extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Date inicio;
	private Date fim;
	private Integer vagas;
	private Turno turno;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "turmas")
	private List<Aluno> alunos = new ArrayList<>();

//	@OneToMany(mappedBy = "id.aluno")
//	private Set<Matricula> matriculas = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(mappedBy = "turma")
	private List<Frequencia> frequencias = new ArrayList<>();

	@OneToMany(mappedBy = "turma")
	private List<NotaBimestre> notasBimestrais = new ArrayList<>();

	public Turma() {
		super();
		this.curso = new Curso();
	}

	public Turma(String nome, Date inicio, Date fim, Integer vagas, Turno turno, Curso curso) {
		super();
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
		this.vagas = vagas;
		this.turno = turno;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

//	public Set<Matricula> getMatriculas() {
//		return matriculas;
//	}
//
//	public void setMatriculas(Set<Matricula> matriculas) {
//		this.matriculas = matriculas;
//	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public List<NotaBimestre> getNotasBimestrais() {
		return notasBimestrais;
	}

	public void setNotasBimestrais(List<NotaBimestre> notasBimestrais) {
		this.notasBimestrais = notasBimestrais;
	}

}
