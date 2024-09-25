package com.example.todoapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val username: String,
    val password: String,
    val email: String,
    val totalTask: Int,
    val completeTask: Int,
    val completeRate: Float
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
