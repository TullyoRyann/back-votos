package com.back.votos.model;

public enum Voto {

	SIM("Sim"),
	NAO("Não");
	
	private String tipo;
	
	public String getTipo() {
		return this.tipo;
	}

	private Voto(String tipo) {
		this.tipo = tipo;
	}
	
}
