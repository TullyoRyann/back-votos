package com.back.votos.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.back.votos.exception.AssociadoJaVoltouException;
import com.back.votos.exception.CpfInvalidoParaVotacaoException;
import com.back.votos.exception.ObjectoNaoEncontradoException;
import com.back.votos.exception.SessaoVotacaoEmAndamentoException;
import com.back.votos.exception.SessaoVotacaoException;
import com.back.votos.model.Pauta;
import com.back.votos.model.ResultadoVoto;
import com.back.votos.model.Votacao;
import com.back.votos.model.Voto;
import com.back.votos.repository.VotacaoRepository;
import com.back.votos.service.PautaService;
import com.back.votos.service.ValidacaoServiceCpf;
import com.back.votos.service.VotacaoService;

@Service
public class VotacaoServiceImpl implements VotacaoService {

	private VotacaoRepository votacaoRepository;

	private PautaService pautaService;

	private ValidacaoServiceCpf validacaoServiceCpf;

	public VotacaoServiceImpl(VotacaoRepository votacaoRepository, PautaService pautaService,
			ValidacaoServiceCpf validacaoServiceCpf) {
		this.votacaoRepository = votacaoRepository;
		this.pautaService = pautaService;
		this.validacaoServiceCpf = validacaoServiceCpf;
	}

	@Override
	public Votacao votar(Votacao votacao) {
		Pauta pauta = pautaService.get(votacao.getPauta().getId());

		if (pauta == null) {
			throw new ObjectoNaoEncontradoException();
		}
		
		if(!validacaoServiceCpf.validar(votacao.getAssociado().getCpf())) {
			throw new CpfInvalidoParaVotacaoException();
		}

		if (pauta.getTempoSessaoVotacao().isBefore(LocalDateTime.now())) {
			throw new SessaoVotacaoException();
		}

		if (associadoJaVoltou(votacao)) {
			throw new AssociadoJaVoltouException();
		}

		return votacaoRepository.save(votacao);
	}

	private boolean associadoJaVoltou(Votacao votacao) {
		return votacaoRepository.existsByAssociadoCpf(votacao.getAssociado().getCpf());
	}

	@Override
	public Integer contarVotosPorPauta(Long id) {
		Pauta pauta = pautaService.get(id);

		if (pauta == null) {
			throw new ObjectoNaoEncontradoException();
		}

		if (pauta.getTempoSessaoVotacao().isAfter(LocalDateTime.now())) {
			throw new SessaoVotacaoEmAndamentoException();
		}

		Integer quantidadeVotos = votacaoRepository.countByPautaId(pauta.getId());
		if (quantidadeVotos == null) {
			quantidadeVotos = 0;
		}

		return quantidadeVotos;
	}

	@Override
	public ResultadoVoto resultadoVotacaoPorPauta(Long id) {
		Integer quantidadeVotosSim = votacaoRepository.countByVotoAndPautaId(Voto.SIM, id);
		if (quantidadeVotosSim == null) {
			quantidadeVotosSim = 0;
		}

		Integer quantidadeVotosNao = votacaoRepository.countByVotoAndPautaId(Voto.NAO, id);
		if (quantidadeVotosNao == null) {
			quantidadeVotosNao = 0;
		}

		if (quantidadeVotosSim.equals(quantidadeVotosNao)) {
			return ResultadoVoto.EMPATE;
		}

		if (quantidadeVotosSim > quantidadeVotosNao) {
			return ResultadoVoto.SIM;
		}

		return ResultadoVoto.NAO;
	}

}
