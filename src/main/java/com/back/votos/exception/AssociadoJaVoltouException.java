package com.back.votos.exception;

public class AssociadoJaVoltouException extends RuntimeException {

	private static final long serialVersionUID = -2348549127096847631L;

	public AssociadoJaVoltouException() {
		super("associado.ja.realizou.votacao");
	}
	
}
