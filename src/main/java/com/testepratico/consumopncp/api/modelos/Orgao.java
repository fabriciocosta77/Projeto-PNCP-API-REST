package com.testepratico.consumopncp.api.modelos;

import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Entidade Orgao, junto de todos os seus atributos
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name="Orgao")
@Entity(name="Orgao")
public class Orgao {
    @Id
    @Column(name="cnpj")
    private String cnpj;

    @Column(name="razaoSocial")
    private String razaoSocial;

    @Column(name="ufNome")
    private String ufNome;

    @Column(name="codigoUnidade")
    private String codigoUnidade;

    @Column(name="nomeUnidade")
    private String nomeUnidade;

    @Column(name="ufSigla")
    private String ufSigla;

    @Column(name="municipioNome")
    private String municipioNome;

    @Column(name="codigoIbge")
    private String codigoIbge;

    @OneToMany(mappedBy = "orgao")
    private List<Contrato> contratos = new ArrayList<>();

    public Orgao(OrgaoDados orgao) {
        this.cnpj = orgao.cnpj();
        this.razaoSocial = orgao.razaoSocial();
        this.ufNome = orgao.ufNome();
        this.codigoUnidade = orgao.codigoUnidade();
        this.nomeUnidade = orgao.nomeUnidade();
        this.ufSigla = orgao.ufSigla();
        this.municipioNome = orgao.municipioNome();
        this.codigoIbge = orgao.codigoIbge();
    }

    public Orgao(OrgaoEntidadeDados orgaoEntidade, OrgaoUnidadeDados unidadeOrgao) {
        this.cnpj = orgaoEntidade.cnpj();
        this.razaoSocial = orgaoEntidade.razaoSocial();
        this.ufNome = unidadeOrgao.ufSigla();
        this.codigoUnidade = unidadeOrgao.codigoUnidade();
        this.nomeUnidade = unidadeOrgao.nomeUnidade();
        this.ufSigla = unidadeOrgao.ufSigla();
        this.municipioNome = unidadeOrgao.municipioNome();
        this.codigoIbge = unidadeOrgao.codigoIbge();
    }

}
