package com.testepratico.consumopncp.api.modelos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

// Mapeamento da resposta do json obtido pelo serviço ConsomeApi
@Getter @AllArgsConstructor @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaJson {
    private List<ContratoDados> data;
    private Integer totalRegistros;
    private Integer totalPaginas;
    private Integer numeroPagina;
    private Integer paginasRestantes;
    private Boolean empty;
}
