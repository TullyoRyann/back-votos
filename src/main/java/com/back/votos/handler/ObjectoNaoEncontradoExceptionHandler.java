package com.back.votos.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.back.votos.exception.ObjectoNaoEncontradoException;

@ControllerAdvice
public class ObjectoNaoEncontradoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ObjectoNaoEncontradoException.class)
	public ResponseEntity<Object> handleObjectoNaoEncontradoException(final ObjectoNaoEncontradoException e,
			WebRequest request) {

		return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
