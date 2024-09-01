package com.testepratico.consumopncp.api.controlador;

import com.testepratico.consumopncp.api.modelos.ContratoOrgaoDados;
import com.testepratico.consumopncp.api.servicos.PegaContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

// Controlador para integração do back-end com o front-end
@RestController
@RequestMapping
public class ControladorContrato {

    @Autowired
    private PegaContrato pegaContrato;

    @GetMapping("/buscacontratos")
    public List<ContratoOrgaoDados> buscaContratoPorCnpj(@RequestParam("cnpj") String cnpj,
                                                         @RequestParam("dataVigenciaInicial") String dataVigenciaInicial,
                                                         @RequestParam("dataVigenciaFinal") String dataVigenciaFinal) throws IOException, InterruptedException {
        return pegaContrato.obterContratosPorCnpj(cnpj, dataVigenciaInicial, dataVigenciaFinal);
    }
}
