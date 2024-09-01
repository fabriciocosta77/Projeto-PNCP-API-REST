package com.testepratico.consumopncp.api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

// Obtém os dados relevantes do contrato
@JsonIgnoreProperties(ignoreUnknown = true)
public record ContratoDados(String dataVigenciaInicial,
                            String dataVigenciaFinal,
                            String nomeRazaoSocialFornecedor,
                            String objetoContrato,
                            BigDecimal valorInicial,
                            OrgaoEntidadeDados orgaoEntidade,
                            OrgaoUnidadeDados unidadeOrgao) {
}
