package com.epam.izh.rd.online;

import com.epam.izh.rd.online.service.HttpConn;
import com.epam.izh.rd.online.service.SimplePokemonFetchingService;
import com.epam.izh.rd.online.service.SimplePokemonFightingClubService;

import java.io.IOException;

public class Http {
    public static void main(String[] args) throws IOException {
        SimplePokemonFightingClubService simplePokemonFightingClubService = new SimplePokemonFightingClubService();
        SimplePokemonFetchingService simplePokemonFetchingService = new SimplePokemonFetchingService();

        String pokemonName1 = "pikachu";
        String pokemonName2 = "slowpoke";

        simplePokemonFightingClubService.doBattle(simplePokemonFetchingService.fetchByName(pokemonName1), simplePokemonFetchingService.fetchByName(pokemonName2));
    }
}
