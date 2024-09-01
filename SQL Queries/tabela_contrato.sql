USE pncp;

CREATE TABLE Contrato (
	id                        INT      AUTO_INCREMENT PRIMARY KEY,
	cnpjOrgao                 CHAR(14)                           ,
	
	# Datas: "YYYY-MM-DD"
	dataVigenciaInicial       CHAR(10)                           ,
	dataVigenciaFinal         CHAR(10)                           ,
	
	nomeRazaoSocialFornecedor VARCHAR(256)                       ,
	objetoContrato            VARCHAR(256)                       ,
	valorInicial              DECIMAL(8,2)                       ,
	
	CONSTRAINT `FK_cnpjOrgaoXcnpj`
		FOREIGN KEY (cnpjOrgao) REFERENCES Orgao (cnpj)

)