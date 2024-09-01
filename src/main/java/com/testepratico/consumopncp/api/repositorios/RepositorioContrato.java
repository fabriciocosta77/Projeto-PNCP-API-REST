package com.testepratico.consumopncp.api.repositorios;

import com.testepratico.consumopncp.api.modelos.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// Repositório de acesso à tabela Contrato
public interface RepositorioContrato extends JpaRepository<Contrato, Integer> {
    // Query que seleciona todos os contratos que tem as datas dataVigenciaInicial e dataVigenciaFinal específicas que pertencem a um órgão
    @Query("SELECT c FROM Contrato c CROSS JOIN Orgao o WHERE o.cnpj = :cnpj AND c.dataVigenciaInicial = :dataVigenciaInicial AND c.dataVigenciaFinal = :dataVigenciaFinal")
    Optional<List<Contrato>> buscaPorCnpjData(String cnpj, String dataVigenciaInicial, String dataVigenciaFinal);
}
