package com.back.votos.exception;

public class CpfInvalidoParaVotacaoException extends RuntimeException {

	private static final long serialVersionUID = 5792332596287372024L;

	public CpfInvalidoParaVotacaoException() {
		super("UNABLE_TO_VOTE");
	}

}
