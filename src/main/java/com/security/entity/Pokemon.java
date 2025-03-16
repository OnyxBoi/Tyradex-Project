package com.security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "pokedex_id")
    private int pokedexId;

    int generation;
    String category;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    Map<String, String> name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    Map<String, Object> sprites;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<Map<String, String>> types;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<Map<String, Object>> talents;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    Map<String, Integer> stats;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<Map<String, Object>> resistances;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    Map<String, List<Map<String, Object>>> evolution;

    String height;
    String weight;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<String> egg_groups;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    Map<String, Float> sexe;

    int catch_rate;
    int level_100;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<Map<String, Object>> formes;












}
