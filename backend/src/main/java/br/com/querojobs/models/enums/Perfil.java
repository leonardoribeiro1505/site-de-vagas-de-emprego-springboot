package br.com.querojobs.models.enums;

public enum Perfil {

	USUARIO(0, "ROLE_USUARIO");

	private Integer key;

	private String value;

	private Perfil() {
	}

	private Perfil(Integer key, String value) {
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
