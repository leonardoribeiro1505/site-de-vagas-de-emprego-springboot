package br.com.devsoltecnologia.sygesc.models.enums;

public enum Turno {
	
	MANHA(0, "Manhã"), 
	TARDE(1, "Tarde"),
	NOITE(2, "Noite");

	private Integer key;

	private String value;

	private Turno() {
	}

	private Turno(Integer key, String value) {
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
