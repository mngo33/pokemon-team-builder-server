package com.pokemonteambuilder.controller;

import com.pokemonteambuilder.model.AddTeamRequest;
import com.pokemonteambuilder.model.Team;
import com.pokemonteambuilder.model.User;
import com.pokemonteambuilder.repository.UserRepository;
import com.pokemonteambuilder.service.TeamService;
import com.pokemonteambuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public ResponseEntity<User> addNewUser (@RequestParam String userName) {
        User user = userService.addUser(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/{userId}/addTeam")
    public ResponseEntity<Team> addTeam(@PathVariable Integer userId,
                                        @RequestBody AddTeamRequest request) {
        Team team = teamService.addTeamToUser(userId, request.getTeamName(), request.getPokemons());
        return ResponseEntity.ok(team);
    }

    @GetMapping("/{userId}/getTeams")
    public ResponseEntity<List<Team>> getTeamsByUserId(@PathVariable Integer userId) {
        try {
            List<Team> teams = teamService.getAllTeamsByUserId(userId);
            return ResponseEntity.ok(teams);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
