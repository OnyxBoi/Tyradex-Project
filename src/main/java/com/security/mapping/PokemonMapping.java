package com.security.mapping;

import com.security.dto.PokemonDTO;
import com.security.entity.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapping {

    public Pokemon dtoToEntity(PokemonDTO pokemonDTO){
        return Pokemon.builder()
                .pokedexId(pokemonDTO.pokedex_id())
                .generation(pokemonDTO.generation())
                .category(pokemonDTO.category())
                .name(pokemonDTO.name())
                .sprites(pokemonDTO.sprites())
                .types(pokemonDTO.types())
                .talents(pokemonDTO.talents())
                .stats(pokemonDTO.stats())
                .resistances(pokemonDTO.resistances())
                .evolution(pokemonDTO.evolution())
                .height(pokemonDTO.height())
                .weight(pokemonDTO.weight())
                .egg_groups(pokemonDTO.egg_groups())
                .sexe(pokemonDTO.sexe())
                .catch_rate(pokemonDTO.catch_rate())
                .level_100(pokemonDTO.level_100())
                .formes(pokemonDTO.formes())
                .build();
    }

    public PokemonDTO entityToDto(Pokemon pokemon){
        return PokemonDTO.builder()
                .pokedex_id(pokemon.getPokedexId())
                .generation(pokemon.getGeneration())
                .category(pokemon.getCategory())
                .name(pokemon.getName())
                .sprites(pokemon.getSprites())
                .types(pokemon.getTypes())
                .talents(pokemon.getTalents())
                .stats(pokemon.getStats())
                .resistances(pokemon.getResistances())
                .evolution(pokemon.getEvolution())
                .height(pokemon.getHeight())
                .weight(pokemon.getWeight())
                .egg_groups(pokemon.getEgg_groups())
                .sexe(pokemon.getSexe())
                .catch_rate(pokemon.getCatch_rate())
                .level_100(pokemon.getLevel_100())
                .formes(pokemon.getFormes())
                .build();
    }

}
