package com.back.votos.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.back.votos.exception.SessaoVotacaoException;
import com.back.votos.persistation.dto.ResponseTO;

@ControllerAdvice
public class SessaoVotacaoExceptionHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;

	public SessaoVotacaoExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(SessaoVotacaoException.class)
	public ResponseEntity<Object> handleSessaoVotacaoException(final SessaoVotacaoException e, WebRequest request) {

		List<String> messagens = Arrays
				.asList(messageSource.getMessage(e.getMessage(), null, LocaleContextHolder.getLocale()));

		ResponseTO<Object> responseTO = new ResponseTO<>();
		responseTO.setErrors(messagens);

		return handleExceptionInternal(e, responseTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
