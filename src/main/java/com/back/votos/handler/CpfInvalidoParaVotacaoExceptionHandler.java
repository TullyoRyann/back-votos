package com.back.votos.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.back.votos.exception.CpfInvalidoParaVotacaoException;
import com.back.votos.persistation.dto.ResponseTO;

@ControllerAdvice
public class CpfInvalidoParaVotacaoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CpfInvalidoParaVotacaoException.class)
	public ResponseEntity<Object> handleCpfInvalidoParaVotacaoException(final CpfInvalidoParaVotacaoException e,
			WebRequest request) {

		List<String> messagens = Arrays.asList(e.getMessage());
		
		ResponseTO<Object> responseTO = new ResponseTO<>();
		responseTO.setErrors(messagens);

		return handleExceptionInternal(e, responseTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
}
