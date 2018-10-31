package br.com.devsoltecnologia.sygesc.models.enums;

public enum Genero {

	MASCULINO(0, "Masculino"),

	FEMININO(1, "Feminino");

	private Integer key;

	private String value;

	private Genero() {
	}

	private Genero(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
