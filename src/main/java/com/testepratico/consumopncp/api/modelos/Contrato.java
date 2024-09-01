package com.testepratico.consumopncp.api.modelos;

import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;

// Entidade Contrato, junto de todos os seus atributos
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name="Contrato")
@Entity(name="Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="cnpjOrgao")
    private Orgao orgao;

    @Column(name="dataVigenciaInicial")
    private String dataVigenciaInicial;

    @Column(name="dataVigenciaFinal")
    private String dataVigenciaFinal;

    @Column(name="nomeRazaoSocialFornecedor")
    private String nomeRazaoSocialFornecedor;

    @Column(name="objetoContrato")
    private String objetoContrato;

    @Column(name="valorInicial")
    private BigDecimal valorInicial;

    public Contrato(ContratoDados contrato) {
        this.dataVigenciaInicial = contrato.dataVigenciaInicial();
        this.dataVigenciaFinal = contrato.dataVigenciaFinal();
        this.nomeRazaoSocialFornecedor = contrato.nomeRazaoSocialFornecedor();
        this.objetoContrato = contrato.objetoContrato();
        this.valorInicial = contrato.valorInicial();
        this.orgao = new Orgao(contrato.orgaoEntidade(), contrato.unidadeOrgao());
    }
}
