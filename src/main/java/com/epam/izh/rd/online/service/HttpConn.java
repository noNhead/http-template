package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpConn {
    private SimpleObjectMapperFactory simpleObjectMapperFactory = new SimpleObjectMapperFactory();

    public Pokemon HttpGetConnection(String url) throws IOException {
        HttpURLConnection httpPokemon1 = (HttpURLConnection) new URL(url).openConnection();
        httpPokemon1.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(httpPokemon1.getInputStream()));
        return simpleObjectMapperFactory.getObjectMapper().readValue(in, Pokemon.class);
    }

    public void getImage(String url){
        try (InputStream in = new URL(url).openStream()){
            Files.copy(in, Paths.get("src/img.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}