package com.testepratico.consumopncp.api.servicos;

import com.testepratico.consumopncp.api.modelos.*;
import com.testepratico.consumopncp.api.repositorios.RepositorioContrato;
import com.testepratico.consumopncp.api.repositorios.RepositorioOrgao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

// Serviço de obtenção dos dados de contrato no banco de dados MySQL
@Service
public class PegaContrato {

    @Autowired
    private RepositorioContrato repositorioContrato;

    @Autowired
    private RepositorioOrgao repositorioOrgao;

    public List<ContratoOrgaoDados> obterContratosPorCnpj(String cnpj, String dataVigenciaInicial, String dataVigenciaFinal) throws IOException, InterruptedException {

        // Retira caracteres especiais do cnpj
        String cnpjApenasNumeros = cnpj.replaceAll("[-/.]", "");
        Optional<List<Contrato>> contratosPreexistentes = repositorioContrato.buscaPorCnpjData(cnpjApenasNumeros, dataVigenciaInicial, dataVigenciaFinal);

        // Se não houverem contratos preexistentes, faz requisição dos contratos pela API e insere no banco de dados
        // Caso contrário pega as informações diretamente do banco de dados
        if (contratosPreexistentes.isEmpty()) {

            ConsomeApi consomeApi = new ConsomeApi();
            ConverteDados converteDados = new ConverteDados();

            String endereco = "https://pncp.gov.br/api/consulta/v1/contratos?dataInicial=" + dataVigenciaInicial + "&dataFinal=" + dataVigenciaFinal + "&cnpjOrgao=" + cnpjApenasNumeros + "&pagina=1";

            String json = consomeApi.obtemDados(endereco);
            List<ContratoDados> contratos = converteDados.obtemDados(json);

            contratos.forEach(contrato -> {
                repositorioOrgao.save(new Orgao(contrato.orgaoEntidade(), contrato.unidadeOrgao()));
                repositorioContrato.save(new Contrato(contrato));
            });

            return contratos.stream()
                    .map(c -> new ContratoOrgaoDados(
                            c.dataVigenciaInicial(),
                            c.dataVigenciaFinal(),
                            c.nomeRazaoSocialFornecedor(),
                            c.objetoContrato(),
                            c.valorInicial(),
                            new OrgaoDados(
                                    c.orgaoEntidade().cnpj(),
                                    c.orgaoEntidade().razaoSocial(),
                                    c.unidadeOrgao().ufNome(),
                                    c.unidadeOrgao().codigoUnidade(),
                                    c.unidadeOrgao().nomeUnidade(),
                                    c.unidadeOrgao().ufSigla(),
                                    c.unidadeOrgao().municipioNome(),
                                    c.unidadeOrgao().codigoIbge())
                            )
                    )
                    .toList();
        } else {
            List<Contrato> contratos = contratosPreexistentes.get();

            return contratos.stream()
                    .map(c -> new ContratoOrgaoDados(
                            c.getDataVigenciaInicial(),
                            c.getDataVigenciaFinal(),
                            c.getNomeRazaoSocialFornecedor(),
                            c.getObjetoContrato(),
                            c.getValorInicial(),
                            new OrgaoDados(
                                    c.getOrgao().getCnpj(),
                                    c.getOrgao().getRazaoSocial(),
                                    c.getOrgao().getUfNome(),
                                    c.getOrgao().getCodigoUnidade(),
                                    c.getOrgao().getNomeUnidade(),
                                    c.getOrgao().getUfSigla(),
                                    c.getOrgao().getMunicipioNome(),
                                    c.getOrgao().getCodigoIbge())
                            )
                    )
                    .toList();
        }
    }
}
