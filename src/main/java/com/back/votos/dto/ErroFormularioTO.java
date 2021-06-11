package com.back.votos.dto;

public class ErroFormularioTO {

	private String campo;
	private String erro;

	public ErroFormularioTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
