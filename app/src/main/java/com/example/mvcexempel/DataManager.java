package com.example.mvcexempel;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static ArrayList<User> users = new ArrayList<>();

    public User createUser(String name, String password){
        User user = new User(name,password);
        users.add(user);
        return user;
    }

    public boolean validateUser(String name, String password){

        for (User u: users) {
            if(u.getUserName().equals(name)){
                if (u.getPassword().equals(password)){
                    return true;
                }
            }
        }

        return false;
    }

    public  List<User> getUsers() {
        return users;
    }
}
