CREATE TABLE public.associado (
	id bigserial NOT NULL,
	ativo bool NULL,
	data_criacao timestamp NOT NULL,
	cpf varchar(11) NULL,
	CONSTRAINT associado_pkey PRIMARY KEY (id)
);

CREATE TABLE public.pauta (
	id bigserial NOT NULL,
	ativo bool NULL,
	data_criacao timestamp NOT NULL,
	nome varchar(255) NOT NULL,
	tempo_sessao_votacao timestamp NOT NULL,
	CONSTRAINT pauta_pkey PRIMARY KEY (id)
);

CREATE TABLE public.votacao (
	id bigserial NOT NULL,
	ativo bool NULL,
	data_criacao timestamp NOT NULL,
	voto varchar(255) NULL,
	fk_associado int8 NOT NULL,
	fk_pauta int8 NOT NULL,
	CONSTRAINT votacao_pkey PRIMARY KEY (id)
);