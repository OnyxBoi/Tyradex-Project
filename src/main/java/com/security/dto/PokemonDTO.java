package com.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public record PokemonDTO(int pokedex_id,
                         int generation,
                         String category,
                         Map<String, String> name,
                         Map<String, Object> sprites,
                         List<Map<String, String>> types,
                         List<Map<String, Object>> talents,
                         Map<String, Integer> stats,
                         List<Map<String, Object>> resistances,
                         Map<String, List<Map<String, Object>>> evolution,
                         String height,
                         String weight,
                         List<String> egg_groups,
                         Map<String, Float> sexe,
                         int catch_rate,
                         int level_100,
                         List<Map<String, Object>> formes) {
}
