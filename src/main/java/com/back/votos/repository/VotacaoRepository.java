package com.back.votos.repository;

import com.back.votos.model.Votacao;
import com.back.votos.model.Voto;

public interface VotacaoRepository extends BaseRepository<Votacao, Long> {
	
	boolean existsByAssociadoCpf(String cpf);
	
	Integer countByPautaId(Long id);
	
	Integer countByVotoAndPautaId(Voto voto, Long id);
	
}
