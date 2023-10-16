package com.example.mvcexempel;

import android.content.Intent;
import android.widget.Toast;

import java.nio.channels.DatagramChannel;

public class MainPresenter implements MainContract.Presenter {

    DataManager dataManager;
    MainContract.View view;
    Navigator navigator;

    public MainPresenter(DataManager dataManager, MainContract.View view, Navigator navigator) {
        this.dataManager = dataManager;
        this.view = view;
        this.navigator = navigator;
    }

    @Override
    public void onLoginButtonClicked() {
        String name = view.getUserName();
        String password = view.getUserPassword();

        if (dataManager.validateUser(name, password)) {
            view.showLoginSuccessMessage();
            navigator.navigateToMemberActivity();
        } else {
            view.showLoginFaildMessage();
        }
    }

    @Override
    public void onRegisterButtonClicked() {
        String name = view.getUserName();
        String password = view.getUserPassword();

        User u = dataManager.createUser(name,password);
        if (u != null){
            view.showRegisteredSuccessMessage(u);
        } else{
            view.showRegisteredFailedMessage();
        }

    }

    @Override
    public void onViewCreated() {
        //används ej
    }

    @Override
    public void onDestroy() {
        //används ej
    }
}
