package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimplePokemonFetchingService implements PokemonFetchingService {
    SimpleObjectMapperFactory simpleObjectMapperFactory = new SimpleObjectMapperFactory();
    @Override
    public Pokemon fetchByName(String name) throws IllegalArgumentException, IOException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        HttpURLConnection httpPokemon1 = (HttpURLConnection) new URL(url).openConnection();
        httpPokemon1.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(httpPokemon1.getInputStream()));
        return simpleObjectMapperFactory.getObjectMapper().readValue(in, Pokemon.class);
    }

    @Override
    public byte[] getPokemonImage(Pokemon pokemon) throws IllegalArgumentException, IOException {
        URL url = null;
        url = new URL(pokemon.getImgUrl());
        InputStream in = null;
        in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }
}
