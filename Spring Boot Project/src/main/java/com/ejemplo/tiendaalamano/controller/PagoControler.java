package com.ejemplo.tiendaalamano.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.ejemplo.tiendaalamano.respuestas.RespuetaString;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/pago")
public class PagoControler {

    private String url = "https://api.mercadopago.com/v1/payments?access_token=TEST-363519645343512-120414-c773893b9674cf6e1c40cee821336d93-608525630";

    
    @RequestMapping(value = "/saludar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getString() {
        return Collections.singletonMap("response", "Hello World");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String nuevoPago(@RequestBody String nuevoPago, @RequestHeader("X-neli-session-id") String deviceId) {
        String respuesta = crearPago(nuevoPago, deviceId);
    
        return respuesta;
    }

    private String crearPago(String dataPago, String deviceId) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-neli-session-id", deviceId)
                .POST(BodyPublishers.ofString(dataPago))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());
        return response.body();
    }
}
