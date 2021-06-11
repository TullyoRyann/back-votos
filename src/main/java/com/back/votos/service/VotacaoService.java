package com.back.votos.service;

import com.back.votos.model.ResultadoVoto;
import com.back.votos.model.Votacao;

public interface VotacaoService {

	Votacao votar(Votacao votacao);

	ResultadoVoto resultadoVotacaoPorPauta(Long id);

	Integer contarVotosPorPauta(Long id);

}
