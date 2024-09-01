package com.testepratico.consumopncp.api.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testepratico.consumopncp.api.modelos.ContratoDados;
import com.testepratico.consumopncp.api.modelos.RespostaJson;
import org.springframework.stereotype.Service;

import java.util.List;

// Serviço de conversão dos dados lidos em json
@Service
public class ConverteDados {

    private ObjectMapper mapeador = new ObjectMapper();

    public List<ContratoDados> obtemDados(String json) {

        // Mapeia o json e transforma em um objeto RespostaJson, cujo atributo "data" são objetos Contrato
        try {
            RespostaJson response = mapeador.readValue(json, RespostaJson.class);
            return response.getData();
        } catch (JsonMappingException e) {
            throw new RuntimeException("Erro no mapeamento do json: " + e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro na desserialização do json: " + e);
        }
    }
}