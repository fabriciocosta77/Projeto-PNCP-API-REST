package com.testepratico.consumopncp.api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Obtém os dados relevantes do "orgaoEntidade"
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrgaoEntidadeDados(String cnpj,
                                 String razaoSocial) {
}
