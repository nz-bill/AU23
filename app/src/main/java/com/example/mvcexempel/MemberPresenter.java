package com.example.mvcexempel;

import java.util.List;

public class MemberPresenter implements MemberContract.Presenter{

    DataManager dataManager;
    MemberContract.View view;

    public MemberPresenter(DataManager dataManager, MemberContract.View view) {
        this.dataManager = dataManager;
        this.view = view;
    }

    @Override
    public void onViewCreated() {
        List<User> users = dataManager.getUsers();
        view.displayMembers(users);
    }

    @Override
    public void onDestroy() {

    }
}
