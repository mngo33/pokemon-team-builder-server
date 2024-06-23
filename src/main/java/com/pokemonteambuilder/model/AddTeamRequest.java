package com.pokemonteambuilder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddTeamRequest {
    private Set<Integer> pokemons;
    private String teamName;
}
