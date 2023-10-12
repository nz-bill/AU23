package com.example.mvvmexempel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private DataManager dataManager = new DataManager();
    private MutableLiveData<Boolean> loginResultLiveData = new MutableLiveData<>();

    private MutableLiveData<User> registeredResultLiveData = new MutableLiveData<>();

    public LiveData<User> getregisteredResultLiveData(){
        return registeredResultLiveData;
    }

    public LiveData<Boolean> getLoginResultLiveData(){
        return loginResultLiveData;
    }

    public void register(String name, String password){
        User newUser = dataManager.createUser(name, password);
        registeredResultLiveData.setValue(newUser);
    }

    public void login(String name, String password){
        boolean isValid = dataManager.validateUser(name, password);
        loginResultLiveData.setValue(isValid);
    }


}
