package com.security.controller;

import com.security.dto.PokemonDTO;
import com.security.entity.Pokemon;
import com.security.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/crud/pokemon")
    public void addPokemon(@RequestBody PokemonDTO pokemonDTO) {
        pokemonService.addPokemon(pokemonDTO);
    }

    @PostMapping("/scrapper/Pokemons")
    public void scrapAllPokemons() {
        pokemonService.scrapAllPokemons();
    }

    @GetMapping("crud/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        return pokemonService.getPokemonByPokedexId(id);
    }

    @DeleteMapping("/crud/pokemon/{id}")
    public void deletePokemon(@PathVariable int id) {
        System.out.println("J'ai envie de me faire sauter le caisson");
        pokemonService.deletePokemonByPokedexId(id);
    }

    @PutMapping("/crud/pokemon/{id}")
    public void updatePokemon(@RequestBody PokemonDTO pokemonDTO, @PathVariable int id) {
        pokemonService.updatePokemon(pokemonDTO, id);
    }

    @GetMapping("/bouncer/api/v1/pokemon/{id}")
    public Pokemon gounceGetPokemon(@PathVariable int id) {
        return pokemonService.bounceGetPokemon(id);
    }
}
