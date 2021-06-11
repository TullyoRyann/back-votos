package com.back.votos.infrastructure.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.votos.persistation.dto.ResponseTO;

@Service
public class ResponseServiceImpl {

	public <T> ResponseEntity<ResponseTO<T>> create(T data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTO<T>(data));
	}

    public <T> ResponseEntity<ResponseTO<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseTO<T>(data));
    }
	
}
