package com.kevin.modelo;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public Moneda cambiarMoneda(String moneda1, String moneda2, double valor){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d3940d96017a01504ee83fde/pair/"+moneda1+"/"+moneda2+"/"+valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("Error al realizar el cambio.");
        }

    }

}
