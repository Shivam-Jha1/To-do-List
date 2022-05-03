package com.coder178.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class userDatabase: RoomDatabase() {

    abstract fun userdao(): userDao

    companion object{
        @Volatile //visible to other threads
        private var INSTANCE:userDatabase? = null    //Singelton class so it will have one instance

        fun getDatabase(context: Context): userDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    userDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}