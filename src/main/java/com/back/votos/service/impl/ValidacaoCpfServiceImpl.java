package com.back.votos.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.back.votos.service.ValidacaoServiceCpf;
import com.back.votos.util.CpfUtil;

@Service
public class ValidacaoCpfServiceImpl implements ValidacaoServiceCpf {

	private static final String CPF_VALIDO = "VERDADEIRO";

	@Value("${api.validacao.cpf}")
	private String uri;

	private RestTemplate restTemplate;

	public ValidacaoCpfServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean validar(String cpf) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("acao", "validar_cpf");
		map.add("txt_cpf", CpfUtil.formatarCpf(cpf));

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		return isCpfValido(response.getBody());
	}

	private static boolean isCpfValido(String body) {
		CharSequence status = body.subSequence(17, body.length());
		return CPF_VALIDO.equals(status.toString().toUpperCase());
	}

}
