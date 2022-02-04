package com.example.fruitmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


@Entity(tableName = "user_database")
class FruitsData(

    @PrimaryKey

    var likeImage: Int = 0,

    var image: Int = 0,

    var title: String = "",

    var per_kg: String = "",

    var nutrition_1: String = "",

    var description: String = "",

    var currentDate: String = SimpleDateFormat("dd/MMM/yy", Locale.getDefault()).format(Date()),

//    val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()),

    var isClicked: Boolean = false,

    var id: Int? = null

): Serializable