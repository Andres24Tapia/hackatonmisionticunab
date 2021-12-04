package com.ejemplo.tiendaalamano.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/pago")
public class PagoControler {

    private String url = "https://api.mercadopago.com/v1/payments?access_token=TEST-363519645343512-120414-c773893b9674cf6e1c40cee821336d93-608525630";

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String nuevoPago(@RequestBody String nuevoPago) {
        return crearPago(nuevoPago);
    }

    private String crearPago(String dataPago) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-neli-session-id", "armor.39ebcd22ee5deb726931008fd5be74791beb4742fc07a3eed680c46a5ea1bf9efe9c5fd0297915f18afaa8bb7497f78b114f2bbc1cd449f94c0f5f50971b16e05d1ae0d21f063694b0ec3209e9a23a02.29fed7c03675874db4eb88731697484c")
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
