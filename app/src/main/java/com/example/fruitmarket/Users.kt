package com.example.fruitmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "user_database")
data class Users(

    @PrimaryKey

    var login: String = "",

    var password: String = "",

    var mail: String = "",

    var name: String = "",

    var favoritesLis: String = "",

    var ordersList: String = "",

    var photo: Int? = 0,

    var likeImage: Int = 0,

    var image: Int = 0,

    var title: String = "",

    var per_kg: String = "",

    var nutrition_1: String = "",

    var description: String = "",

    var currentDate: String = "",

//    var favoritesList: MutableList<FruitsData> = ArrayList(),
//
//    var ordersList: MutableList<FruitsData> = ArrayList(),

    var userId: String = UUID.randomUUID().toString(),

//var favoritesList: MutableList<FruitsData> = ArrayList() ,
//
//var ordersList: MutableList<FruitsData> = ArrayList()

) : Serializable, Converter()


    open class Converter {

        @TypeConverter
        fun listToJson(value: List<FruitsData>?) = Gson().toJson(value)

        @TypeConverter
        fun JsonToList(value: String) = Gson().fromJson(value, Array<FruitsData> ::class.java).toList()

    }



//    @TypeConverter
//    fun favoritesList(value : MutableList<FruitsData>): String {
//        val gson = Gson()
//        val type = object : TypeToken<MutableList<FruitsData>>() {}.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun favoritesList(value: String): MutableList<FruitsData> {
//        val gson = Gson()
//        val type = object : TypeToken<MutableList<FruitsData>>() {}.type
//        return gson.fromJson(value, type)
//    }









