package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User {
    public Employee(String name, String userId, String email, String password){
        super(name, userId, email, password);
    };

    public String getUserType(){
        return "Employee";
    }
}