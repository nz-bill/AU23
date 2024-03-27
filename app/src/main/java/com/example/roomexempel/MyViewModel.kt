package com.example.roomexempel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {
    private val repo: UserRepository
    private val allUser: LiveData<List<User>>

    init {
        val userDao = DataBase.getDatabase(application).userDao()
        repo = UserRepository(userDao)
        allUser = repo.allUsers
    }

    fun addUser(user: User){
        viewModelScope.launch {
            repo.addUser(user)
        }

    }

    fun getAllUser(): LiveData<List<User>>{
       return repo.allUsers
    }

    fun deleteUser(user: User) = viewModelScope.launch{
        repo.deleteUser(user)
    }

    fun updateUser(user: User) = viewModelScope.launch {
        repo.updateUser(user)
    }


}