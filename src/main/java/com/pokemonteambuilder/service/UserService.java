package com.pokemonteambuilder.service;

import com.pokemonteambuilder.model.User;
import com.pokemonteambuilder.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User addUser(String userName) {
        User user = new User();
        user.setUsername(userName);
        userRepository.save(user);
        return user;
    }
}
