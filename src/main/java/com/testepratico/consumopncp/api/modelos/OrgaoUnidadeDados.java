package com.testepratico.consumopncp.api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Obtém os dados relevantes "unidadeOrgao"
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrgaoUnidadeDados(String ufNome,
                                String codigoUnidade,
                                String nomeUnidade,
                                String ufSigla,
                                String municipioNome,
                                String codigoIbge) {
}
