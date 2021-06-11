package com.back.votos.assembler;

import java.time.LocalDateTime;

import com.back.votos.dto.pauta.PautaRequestTO;
import com.back.votos.model.Pauta;

public class PautaAssembler {

	public static Pauta from(PautaRequestTO requestTO) {
		Pauta pauta = new Pauta();
		LocalDateTime segundos = null;
		if (requestTO.getTempoSessaoVotacaoSegundos() == null) {
			segundos = LocalDateTime.now().plusSeconds(60);
		} else {
			segundos = LocalDateTime.now().plusSeconds(requestTO.getTempoSessaoVotacaoSegundos());
		}
		pauta.setTempoSessaoVotacao(segundos);
		pauta.setNome(requestTO.getNome());
		return pauta;
	}

}
