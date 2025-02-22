package org.example.Database;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.example.Model.User;

@Getter
@Setter
public class UserDB {
    private List<User> users;

    public UserDB() {
        users = new ArrayList<>();
    }

    public void addUser(User u){
        users.add(u);
    }

    public User searchUser(String email){
        for (var u: users){
            if (u.isDeleted()) continue;
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public int deleteUser(String email){
        for (var u: users){
            if (u.getEmail().equals(email)){
                u.setDeleted(true);
                return 0;
            }
        }
        return 1;
    }
}