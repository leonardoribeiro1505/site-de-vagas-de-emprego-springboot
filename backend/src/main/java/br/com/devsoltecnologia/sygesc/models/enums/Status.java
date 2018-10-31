package br.com.devsoltecnologia.sygesc.models.enums;

public enum Status {
	
	MATRICULADO(0, "Matriculado"), 
	PENDENTE(1, "Pendente");

	private Integer key;

	private String value;

	private Status() {
	}

	private Status(Integer key, String value) {
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
