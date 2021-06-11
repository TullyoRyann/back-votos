package com.back.votos.exception;

public class SessaoVotacaoException extends RuntimeException {

	private static final long serialVersionUID = -2596647774650518635L;
	
	public SessaoVotacaoException() {
		super("pauta.sessao.de.votacao.encerrado");
	}

}
