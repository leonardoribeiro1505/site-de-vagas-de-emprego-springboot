package br.com.devsoltecnologia.sygesc.models.enums;

public enum Mes {
	
	JANEIRO(0, "Janeiro"), 
	FEVEREIRO(1, "Fevereiro"),
	MARCO(2, "Março"),
	ABRIL(3, "Abril"),
	MAIO(4, "Maio"),
	JUNHO(5, "Junho"),
	JULHO(6, "Julho"),
	AGOSTO(7, "Agosto"),
	SETEMBRO(8, "Setembro"),
	OUTUBRO(9, "Outubro"),
	NOVEMBRO(10, "Novembro"),
	DEZEMBRO(11, "Dezembro");

	private Integer key;

	private String value;

	private Mes() {
	}

	private Mes(Integer key, String value) {
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
