USE pncp;

CREATE TABLE Orgao (
	# Do json "orgaoEntidade" 
	cnpj          CHAR(14)      PRIMARY KEY,
	razaoSocial   VARCHAR(256)             ,
	
	# Do json "unidadeOrgao"
	ufNome        VARCHAR(256)             ,
	codigoUnidade VARCHAR(10)              ,
	nomeUnidade   VARCHAR(256)             ,
	ufSigla       CHAR(2)                  ,
	municipioNome VARCHAR(256)             ,
	codigoIbge    CHAR(7)
);