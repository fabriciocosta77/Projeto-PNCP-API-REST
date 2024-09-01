package com.testepratico.consumopncp.api.modelos;

// Obtém os dados relevantes do órgão
public record OrgaoDados(String cnpj,
                         String razaoSocial,
                         String ufNome,
                         String codigoUnidade,
                         String nomeUnidade,
                         String ufSigla,
                         String municipioNome,
                         String codigoIbge) {
}
