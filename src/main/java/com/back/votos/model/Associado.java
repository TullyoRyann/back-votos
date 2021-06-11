package com.back.votos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "associado")
public class Associado extends BaseEntity {

	private static final long serialVersionUID = 8495554884576152816L;

	@NotNull
	@Column(name = "cpf", length = 11)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
