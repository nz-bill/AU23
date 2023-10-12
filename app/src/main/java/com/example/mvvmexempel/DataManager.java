package com.example.mvvmexempel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static MutableLiveData<List<User>> usersLiveData = new MutableLiveData<>();

    public ArrayList<User> users = new ArrayList<>();

    public LiveData<List<User>> getUserLiveData(){
        return  usersLiveData;
    }
    public User createUser(String name, String password){
        User user = new User(name,password);
        users.add(user);
        usersLiveData.setValue(users);
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
