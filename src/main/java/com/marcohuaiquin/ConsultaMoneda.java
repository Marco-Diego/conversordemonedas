package com.marcohuaiquin;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public static final String API_KEY = "386bc0ece319d27d606b27e5";

    public Double convierteMoneda(String monedaOrigen, String monedaDestino, Double monto) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            if (moneda.result().equals("success")) {
                return moneda.conversion_result();
            }
            else {
                throw new RuntimeException("No se encontró el par de monedas.");
            }
        }
        catch (Exception e) {
            throw new RuntimeException("No se encontró el par de monedas.");
        }
    }

}
