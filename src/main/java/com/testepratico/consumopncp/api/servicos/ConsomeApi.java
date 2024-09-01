package com.testepratico.consumopncp.api.servicos;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Serviço para consumir a api PNCP
@Service
public class ConsomeApi {

    public String obtemDados(String endereco) throws IOException, InterruptedException {

        // Abre um cliente e uma requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        // Envia a requisição e retorna a resposta
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
