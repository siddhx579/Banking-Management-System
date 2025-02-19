package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class User {

    private String name;
    private String userId;
    private String email;
    private String password;
    private boolean isDeleted;

    public User() {
    }

    public User(String name, String userId, String email, String password) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.isDeleted = false;
    }
}