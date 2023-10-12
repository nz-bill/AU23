package com.example.mvvmexempel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MemberViewModel extends ViewModel {
    private DataManager dataManager = new DataManager();

    public LiveData<List<User>> getUserListLiveData(){
        return dataManager.getUserLiveData();
    }

}
