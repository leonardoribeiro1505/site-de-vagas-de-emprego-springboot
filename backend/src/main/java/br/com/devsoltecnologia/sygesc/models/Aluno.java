package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	private Date data;
	private String numeroRegistroCartorio;
	private String livro;
	private String folha;
	private String cartorio;

	@ManyToMany
	@JoinTable(name = "ALUNO_RESPONSAVEL", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "responsavel_id"))
	private List<Responsavel> responsaveis = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "ALUNO_TURMA", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();

//	@OneToMany(mappedBy = "id.turma")
//	private Set<Matricula> matriculas = new HashSet<>();

	public Aluno() {
		super();
		this.pessoa = new Pessoa();
	}

	public Aluno(Date data, String numeroRegistroCartorio, String livro, String folha, String cartorio) {
		super();
		this.data = data;
		this.numeroRegistroCartorio = numeroRegistroCartorio;
		this.livro = livro;
		this.folha = folha;
		this.cartorio = cartorio;
	}

//	public List<Turma> getTurma() {
//		List<Turma> lista = new ArrayList<>();
//		for (Matricula x : matriculas) {
//			lista.add(x.getTurma());
//		}
//		return lista;
//	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumeroRegistroCartorio() {
		return numeroRegistroCartorio;
	}

	public void setNumeroRegistroCartorio(String numeroRegistroCartorio) {
		this.numeroRegistroCartorio = numeroRegistroCartorio;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	public String getCartorio() {
		return cartorio;
	}

	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

//	public Set<Matricula> getMatriculas() {
//		return matriculas;
//	}
//
//	public void setMatriculas(Set<Matricula> matriculas) {
//		this.matriculas = matriculas;
//	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
