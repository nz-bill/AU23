package com.example.realmexempel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val repo = Repository()
    private val users = repo.users

    fun addUser(user:User){
        viewModelScope.launch {
            repo.addUser(user)
        }
    }

    fun getAllUsers(): LiveData<List<User>>{
        return users

    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            repo.deleteUser(user)
        }
    }
}