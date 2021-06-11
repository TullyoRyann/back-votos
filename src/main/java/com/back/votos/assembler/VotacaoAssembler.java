package com.back.votos.assembler;

import com.back.votos.dto.votacao.VotacaoRequestTO;
import com.back.votos.dto.votacao.VotacaoResponseTO;
import com.back.votos.dto.votacao.VotacaoResultadoPautaResponseTO;
import com.back.votos.exception.ArgumentoIlegalException;
import com.back.votos.model.Associado;
import com.back.votos.model.Pauta;
import com.back.votos.model.ResultadoVoto;
import com.back.votos.model.Votacao;
import com.back.votos.model.Voto;

public class VotacaoAssembler {

	public static Votacao from(VotacaoRequestTO requestTO) {
		Pauta pauta = new Pauta();
		pauta.setId(requestTO.getPautaId());
		
		Associado associado = new Associado();
		associado.setCpf(requestTO.getAssociadoCpf());
		
		try {
			Voto voto = Voto.valueOf(requestTO.getVoto().toUpperCase());
			return new Votacao(
					voto, 
					associado,
					pauta);
		} catch (IllegalArgumentException e) {
			throw new ArgumentoIlegalException();
		}
	}

	public static VotacaoResponseTO from(Votacao votacao) {

		return new VotacaoResponseTO(
				votacao.getPauta().getId(), 
				votacao.getAssociado().getCpf(),
				votacao.getVoto().getTipo());
	}
	
	public static VotacaoResultadoPautaResponseTO from(int quantidadeVotos, ResultadoVoto resultadoVoto) {
		return new VotacaoResultadoPautaResponseTO(quantidadeVotos, resultadoVoto.getTipo());
	}
	
}
