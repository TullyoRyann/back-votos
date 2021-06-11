package com.back.votos.dto.votacao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VotacaoRequestTO {

	@NotNull
	private Long pautaId;

	@NotNull
	@NotEmpty
	@Size(min=11, max=11)
	private String associadoCpf;

	@NotNull
	@NotEmpty
	private String voto;

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
