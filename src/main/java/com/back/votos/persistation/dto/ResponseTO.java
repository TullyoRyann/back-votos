package com.back.votos.persistation.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseTO<T> implements Serializable {

	private static final long serialVersionUID = 206320162969230235L;

	private T data;
	private List<String> errors = new ArrayList<>();
	private List<String> links = new ArrayList<>();

	public ResponseTO() {
	}

	public ResponseTO(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
}
