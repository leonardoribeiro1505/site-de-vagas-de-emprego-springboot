package br.com.querojobs.models;

import br.com.querojobs.models.enums.Perfil;

public class Authority {
	
	private Perfil perfil;
	
	public Authority() {
		
	}
	
	public Authority(Perfil perfil) {
		this.perfil = perfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}

