package com.coder178.roomdatabase.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repositiry: UserRepositiry

    init {
        val UserDao = userDatabase.getDatabase(application).userdao()
        repositiry = UserRepositiry(UserDao)
        readAllData = repositiry.readAllData
    }
    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repositiry.addUser(user)
        }
    }
}