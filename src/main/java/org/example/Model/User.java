package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public abstract class User {
    private String id;
    private String name;
    private String email;;
    private String password;
    private String role;

    public User(String id, String name, String email, String password, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}