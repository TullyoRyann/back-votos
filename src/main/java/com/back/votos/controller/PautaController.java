package com.back.votos.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.votos.assembler.PautaAssembler;
import com.back.votos.dto.pauta.PautaRequestTO;
import com.back.votos.dto.pauta.PautaResponseTO;
import com.back.votos.infrastructure.service.ResponseServiceImpl;
import com.back.votos.model.Pauta;
import com.back.votos.persistation.dto.ResponseTO;
import com.back.votos.service.PautaService;

@RestController
@RequestMapping("/pautas")
public class PautaController {

	private PautaService pautaService;

	private ModelMapper modelMapper;

	private ResponseServiceImpl responseService;

	private PautaController(PautaService pautaService, ModelMapper modelMapper, ResponseServiceImpl responseService) {
		this.pautaService = pautaService;
		this.modelMapper = modelMapper;
		this.responseService = responseService;
	}

	@PostMapping
	public ResponseEntity<ResponseTO<PautaResponseTO>> cadastrar(@Valid @RequestBody PautaRequestTO requestTO) {
		Pauta pauta = pautaService.cadastrar(PautaAssembler.from(requestTO));
		return responseService.create(modelMapper.map(pauta, PautaResponseTO.class));
	}

}
