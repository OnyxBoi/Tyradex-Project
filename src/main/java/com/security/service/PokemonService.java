package com.security.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.dto.PokemonDTO;
import com.security.entity.Pokemon;
import com.security.mapping.PokemonMapping;
import com.security.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonMapping pokemonMapping;

    private final String API_URL = "https://tyradex.app/api/v1/pokemon";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void addPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = pokemonMapping.dtoToEntity(pokemonDTO);
        pokemonRepository.save(pokemon);
        System.out.println("Pokemon added successfully");
    }

    public void scrapAllPokemons() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Map<String, Object>> pokemonList = objectMapper.readValue(response.body(), new TypeReference<>() {});
            savePokemonBatch(pokemonList);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error fetching Pokémon data: " + e.getMessage(), e);
        }
    }

    private void savePokemonBatch(List<Map<String, Object>> pokemonList) {
        int batchSize = 200;
        int totalSize = pokemonList.size();

        for (int start = 0; start < totalSize; start += batchSize) {
            int end = Math.min(start + batchSize, totalSize);
            System.out.println("Processing Pokémon from index " + start + " to " + (end - 1));

            for (int i = start; i < end; i++) {
                Map<String, Object> pokemonData = pokemonList.get(i);
                PokemonDTO pokemonDTO = objectMapper.convertValue(pokemonData, PokemonDTO.class);
                Pokemon pokemon = pokemonMapping.dtoToEntity(pokemonDTO);
                pokemonRepository.save(pokemon);
            }
        }
    }

    public Pokemon getPokemonByPokedexId(int pokedexId) {
        return pokemonRepository.findByPokedexId(pokedexId)
                .orElseThrow(() -> new RuntimeException("Pokemon not found with Pokedex ID: " + pokedexId));
    }

    public void deletePokemonByPokedexId(int pokedexId) {
        Optional<Pokemon> pokemon = pokemonRepository.findByPokedexId(pokedexId);
        pokemon.ifPresent(pokemonRepository::delete);
    }

    public void updatePokemon(PokemonDTO pokemonDTO, int id) {
        Pokemon updatedPokemon = pokemonMapping.dtoToEntity(pokemonDTO);
        Pokemon currentPokemon = pokemonRepository.findByPokedexId(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found with Pokedex ID: " + id));

        updatedPokemon.setId(currentPokemon.getId());
        updatedPokemon.setPokedexId(id);

        pokemonRepository.save(updatedPokemon);

    }

    public Pokemon bounceGetPokemon(int id) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL + "/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Map<String, Object> pokemonData = objectMapper.readValue(response.body(), new TypeReference<>() {});

            PokemonDTO pokemonDTO = objectMapper.convertValue(pokemonData, PokemonDTO.class);
            return pokemonMapping.dtoToEntity(pokemonDTO);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error fetching Pokémon data: " + e.getMessage(), e);
        }


    }
}
