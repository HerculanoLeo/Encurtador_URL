CREATE TABLE public.tb_url (
	id integer NOT NULL,
	code VARCHAR(20) NOT NULL,
	url TEXT NOT NULL,
	dt_criacao TIMESTAMP NOT NULL,
	dt_validade TIMESTAMP NULL,
	status VARCHAR(3) NOT NULL,
	CONSTRAINT tb_url_pkey PRIMARY KEY (id),
	CONSTRAINT tb_url_uc_code UNIQUE(code)
);

CREATE SEQUENCE public.sq_url
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
CREATE TABLE public.tb_configuracao (
	codigo VARCHAR(50) NOT NULL,
	valor VARCHAR(50) NOT NULL,
	
	CONSTRAINT tb_configuracao_pkey PRIMARY KEY (codigo)
);