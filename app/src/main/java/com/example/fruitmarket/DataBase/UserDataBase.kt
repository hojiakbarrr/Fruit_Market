package com.example.fruitmarket.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fruitmarket.Users

@Database(entities = [Users :: class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {


    abstract fun allUsersDao(): UserssDao

//    abstract fun countriesDao(): UserssDao

    companion object {
        @Volatile
        var INSTANCE: UserDataBase? = null

        fun getDatabaseInstance(context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDataBaseinstance = Room.databaseBuilder(context,
                    UserDataBase::class.java, "UserEs"
                ).allowMainThreadQueries().build()
                INSTANCE = roomDataBaseinstance
                return return roomDataBaseinstance
            }

        }

    }
}