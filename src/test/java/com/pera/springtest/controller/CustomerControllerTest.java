package com.pera.springtest.controller;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Repeat;

import java.io.IOException;

public class CustomerControllerTest {

    @Test
    void findAllTest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .addHeader("Content-Type","application/json")
                .url("http://localhost:9090/customer/getall")
                .method("GET",null)
                .build();
       Response response =  client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test
    @Repeat(100)
    void saveTest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType,"{\n" +
                "    \"name\": \"john Black\",\n" +
                "    \"address\": \"Istanbul\",\n" +
                "    \"phone\": \"0 555 999 8877\"\n" +
                "}");
        Request request = new Request.Builder()
                .addHeader("Content-Type","application/json")
                .url("http://localhost:9090/customer/save")
                .method("POST",requestBody)
                .build();
        Response response =  client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
