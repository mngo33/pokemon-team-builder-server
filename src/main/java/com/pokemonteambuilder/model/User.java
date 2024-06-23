package com.pokemonteambuilder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")  // Ensures the foreign key is mapped
    private Set<Team> teams;
}
