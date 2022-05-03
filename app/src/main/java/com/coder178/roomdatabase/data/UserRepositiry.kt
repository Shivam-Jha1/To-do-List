package com.coder178.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepositiry (private val userdao:userDao){
    val readAllData: LiveData<List<User>> = userdao.readAllData()

    suspend fun addUser(user:User){
        userdao.addUser(user)
    }
}