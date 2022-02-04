package com.example.fruitmarket.DataBase

import androidx.room.*
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.Users


@Dao
interface UserssDao {

//    @Query("select * from user_database")
//    fun getAllFruits(): MutableList<FruitsData>?
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun add_favorites(fruit: FruitsData)
//
//    @Delete
//    fun delete_favotites(fruit: FruitsData)
/////////////***/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun add_orders(user: Users)
//
//    @Delete
//    fun delete_orders(user: Users)

    ////////////////////////////////////////////////////////// ////////
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add_New_User(user: Users)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update_User(user: Users)

    @Delete
    fun delete_User(user: Users)

    @Query("select * from user_database")
    fun getAllUser(): MutableList<Users>?

    @Query("select * from user_database where  userId ==:ceId")
    fun getUser(ceId: Int): Users
}