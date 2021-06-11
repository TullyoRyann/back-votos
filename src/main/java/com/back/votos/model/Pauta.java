package com.back.votos.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "pauta")
public class Pauta extends BaseEntity {

	private static final long serialVersionUID = 2185518439598446778L;

	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull
	@Column(name = "tempo_sessao_votacao", nullable = false)
	private LocalDateTime tempoSessaoVotacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getTempoSessaoVotacao() {
		return tempoSessaoVotacao;
	}

	public void setTempoSessaoVotacao(LocalDateTime tempoSessaoVotacao) {
		this.tempoSessaoVotacao = tempoSessaoVotacao;
	}

}
