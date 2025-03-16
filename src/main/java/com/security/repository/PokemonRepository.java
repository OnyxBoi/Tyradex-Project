package com.security.repository;

import com.security.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    Optional<Pokemon> findByPokedexId(int pokedexId);

}
