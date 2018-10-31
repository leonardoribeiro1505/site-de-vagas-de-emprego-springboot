package br.com.devsoltecnologia.sygesc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.devsoltecnologia.sygesc.models.enums.Mes;

@Entity
public class FolhaPagamento extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date data;
	private Mes mesReferencia;
	private Double bonus;
	private Double desconto;
	private Double valorSalario;
	private String agencia;
	private String conta;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	public FolhaPagamento() {
	}

	public FolhaPagamento(Date data, Mes mesReferencia, Double bonus, Double desconto, Double valorSalario,
			String agencia, String conta, Funcionario funcionario) {
		super();
		this.data = data;
		this.mesReferencia = mesReferencia;
		this.bonus = bonus;
		this.desconto = desconto;
		this.valorSalario = valorSalario;
		this.agencia = agencia;
		this.conta = conta;
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Mes getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Mes mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorSalario() {
		return valorSalario;
	}

	public void setValorSalario(Double valorSalario) {
		this.valorSalario = valorSalario;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
