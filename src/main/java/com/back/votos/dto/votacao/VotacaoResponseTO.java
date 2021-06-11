package com.back.votos.dto.votacao;

public class VotacaoResponseTO {

	private Long pautaId;
	private String associadoCpf;
	private String voto;

	public VotacaoResponseTO(Long pautaId, String associadoCpf, String voto) {
		this.pautaId = pautaId;
		this.associadoCpf = associadoCpf;
		this.voto = voto;
	}

	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public String getAssociadoCpf() {
		return associadoCpf;
	}

	public void setAssociadoCpf(String associadoCpf) {
		this.associadoCpf = associadoCpf;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

}
