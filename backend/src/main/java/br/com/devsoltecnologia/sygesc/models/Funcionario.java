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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	private Double valorSalario;
	private Date data;

	@ManyToMany
	@JoinTable(name = "FUNCIONARIO_CARGO", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "cargo_id"))
	private List<Cargo> cargos = new ArrayList<>();

	@OneToMany(mappedBy = "funcionario")
	private List<FolhaPagamento> pagamentos = new ArrayList<>();

	public Funcionario() {
		super();
		this.pessoa = new Pessoa();
	}

	public Funcionario(Double valorSalario, Date data) {
		super();
		this.valorSalario = valorSalario;
		this.data = data;
	}

	public Double getValorSalario() {
		return valorSalario;
	}

	public void setValorSalario(Double valorSalario) {
		this.valorSalario = valorSalario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<FolhaPagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<FolhaPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
