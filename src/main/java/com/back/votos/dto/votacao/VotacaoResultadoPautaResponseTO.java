package com.back.votos.dto.votacao;

public class VotacaoResultadoPautaResponseTO {

	private Integer quantidadeVotos;
	private String resultadoVoto;

	public VotacaoResultadoPautaResponseTO(Integer quantidadeVotos, String resultadoVoto) {
		super();
		this.quantidadeVotos = quantidadeVotos;
		this.resultadoVoto = resultadoVoto;
	}

	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}

	public String getResultadoVoto() {
		return resultadoVoto;
	}

	public void setResultadoVoto(String resultadoVoto) {
		this.resultadoVoto = resultadoVoto;
	}

}
