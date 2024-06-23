package com.pokemonteambuilder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "teams")
@Getter @Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ElementCollection
    @CollectionTable(name = "team_pokemon", joinColumns = @JoinColumn(name = "team_id"))
    private Set<Integer> pokemons;
}
