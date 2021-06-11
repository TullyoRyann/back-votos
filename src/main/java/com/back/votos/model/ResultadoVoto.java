package com.back.votos.model;

public enum ResultadoVoto {

	SIM("Sim"),
	NAO("Não"),
	EMPATE("Empate");
	
	private String tipo;
	
	public String getTipo() {
		return this.tipo;
	}

	private ResultadoVoto(String tipo) {
		this.tipo = tipo;
	}
	
	
}
