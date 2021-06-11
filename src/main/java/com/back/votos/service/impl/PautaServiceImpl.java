package com.back.votos.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.back.votos.exception.ObjectoNaoEncontradoException;
import com.back.votos.model.Pauta;
import com.back.votos.repository.PautaRepository;
import com.back.votos.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService {

	private PautaRepository pautaRepository;

	public PautaServiceImpl(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}

	@Override
	public Pauta cadastrar(Pauta pauta) {
		if (pauta == null) {
			throw new ObjectoNaoEncontradoException();
		}
		return pautaRepository.save(pauta);
	}

	@Override
	public Pauta get(Long id) {
		if (id == null) {
			throw new ObjectoNaoEncontradoException();
		}
		Optional<Pauta> optional = pautaRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}