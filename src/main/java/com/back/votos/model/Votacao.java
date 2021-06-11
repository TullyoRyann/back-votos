package com.back.votos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "votacao")
public class Votacao extends BaseEntity {

	private static final long serialVersionUID = -7189651418617311880L;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Voto voto;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_associado", nullable = false)
	private Associado associado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_pauta", nullable = false)
	private Pauta pauta;

	public Votacao() {
		super();
	}

	public Votacao(Voto voto, Associado associado, Pauta pauta) {
		this.voto = voto;
		this.associado = associado;
		this.pauta = pauta;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

}
