package com.coder178.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface userDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //if same user we ignore that
    suspend fun addUser(user: User)  //have to use corutines later

    @Query("SELECT * FROM user_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}