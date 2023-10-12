package com.example.mvcexempel;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<User> users = new ArrayList<>();

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


}
