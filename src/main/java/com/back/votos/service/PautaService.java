package com.back.votos.service;

import com.back.votos.model.Pauta;

public interface PautaService {

	Pauta cadastrar(Pauta pauta);

	Pauta get(Long id);

}
