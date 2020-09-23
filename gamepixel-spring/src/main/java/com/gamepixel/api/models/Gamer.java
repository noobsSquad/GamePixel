package com.gamepixel.api.models;

import javax.persistence.Entity;

@Entity
public class Gamer {
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}