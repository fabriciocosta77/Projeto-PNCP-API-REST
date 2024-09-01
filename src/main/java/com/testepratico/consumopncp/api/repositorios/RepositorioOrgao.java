package com.testepratico.consumopncp.api.repositorios;

import com.testepratico.consumopncp.api.modelos.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositório de acesso à tabela Orgao
public interface RepositorioOrgao extends JpaRepository<Orgao, String> {
}
