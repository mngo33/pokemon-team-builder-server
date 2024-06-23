package com.pokemonteambuilder.service;

import com.pokemonteambuilder.model.Team;
import com.pokemonteambuilder.model.User;
import com.pokemonteambuilder.repository.TeamRepository;
import com.pokemonteambuilder.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Team addTeamToUser(Integer userId, String teamName, Set<Integer> pokemons) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Team team = new Team();
            team.setUserId(user.getId());
            team.setTeamName(teamName);
            team.setPokemons(pokemons);
            user.getTeams().add(team);
            return teamRepository.save(team);
        } else {
            throw new IllegalStateException("User not found");
        }
    }

    public List<Team> getAllTeamsByUserId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return new ArrayList<>(userOptional.get().getTeams());
        } else {
            throw new IllegalStateException("User not found");
        }
    }
}
