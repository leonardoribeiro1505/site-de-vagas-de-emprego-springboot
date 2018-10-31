package br.com.querojobs.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vagas")
public class Vaga extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeCargo;
	private String tipoContratacao;
	private String cargaHoraria;
	private Double salario;
	private Date inicioExibicao;
	private Date fimExibicao;
	private String descricao;

	public Vaga() {
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getTipoContratacao() {
		return tipoContratacao;
	}

	public void setTipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getInicioExibicao() {
		return inicioExibicao;
	}

	public void setInicioExibicao(Date inicioExibicao) {
		this.inicioExibicao = inicioExibicao;
	}

	public Date getFimExibicao() {
		return fimExibicao;
	}

	public void setFimExibicao(Date fimExibicao) {
		this.fimExibicao = fimExibicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
