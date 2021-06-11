package com.back.votos.dto.pauta;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class PautaRequestTO {

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String nome;
	
	@Min(1)
	@Max(60000)
	private Integer tempoSessaoVotacaoSegundos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempoSessaoVotacaoSegundos() {
		return tempoSessaoVotacaoSegundos;
	}

	public void setTempoSessaoVotacaoSegundos(Integer tempoSessaoVotacaoSegundos) {
		this.tempoSessaoVotacaoSegundos = tempoSessaoVotacaoSegundos;
	}

}
