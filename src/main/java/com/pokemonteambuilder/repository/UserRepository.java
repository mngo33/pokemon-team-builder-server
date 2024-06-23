package com.pokemonteambuilder.repository;

import com.pokemonteambuilder.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}