package com.testepratico.consumopncp.api.modelos;

import java.math.BigDecimal;

// Agrupa os todos os dados do contrato quanto todos os dados do órgão
public record ContratoOrgaoDados(String dataVigenciaInicial,
                                 String dataVigenciaFinal,
                                 String nomeRazaoSocialFornecedor,
                                 String objetoContrato,
                                 BigDecimal valorInicial,
                                 OrgaoDados orgao) {
}
