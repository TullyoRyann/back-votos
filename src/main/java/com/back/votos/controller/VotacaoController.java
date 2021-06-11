package com.back.votos.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.votos.assembler.VotacaoAssembler;
import com.back.votos.dto.votacao.VotacaoRequestTO;
import com.back.votos.dto.votacao.VotacaoResponseTO;
import com.back.votos.dto.votacao.VotacaoResultadoPautaResponseTO;
import com.back.votos.infrastructure.service.ResponseServiceImpl;
import com.back.votos.model.ResultadoVoto;
import com.back.votos.model.Votacao;
import com.back.votos.persistation.dto.ResponseTO;
import com.back.votos.service.VotacaoService;

@RestController
@RequestMapping("/votos")
public class VotacaoController {

	private VotacaoService votacaoService;

	private ResponseServiceImpl responseService;

	public VotacaoController(VotacaoService votacaoService, ResponseServiceImpl responseService) {
		this.votacaoService = votacaoService;
		this.responseService = responseService;
	}

	@PostMapping
	public ResponseEntity<ResponseTO<VotacaoResponseTO>> votar(@Valid @RequestBody VotacaoRequestTO requestTO) {
		Votacao votacao = VotacaoAssembler.from(requestTO);
		return responseService.create(VotacaoAssembler.from(votacaoService.votar(votacao)));
	}

	@GetMapping(value = "/resultado/pauta/{id}")
	public ResponseEntity<ResponseTO<VotacaoResultadoPautaResponseTO>> resultado(@PathVariable Long id) {
		int quantidadeVotos = votacaoService.contarVotosPorPauta(id);
		ResultadoVoto resultadoVoto = votacaoService.resultadoVotacaoPorPauta(id);
		return responseService.ok(VotacaoAssembler.from(quantidadeVotos, resultadoVoto));
	}

}
