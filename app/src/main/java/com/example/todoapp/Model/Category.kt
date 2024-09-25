package com.example.todoapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    val title: String,
    val icon: String?,
    val yearlyTask: Int,
    val weeklyTask: Int,
    val totalTask: Int,
    val completeTask: Int,
    val completeRate: Float
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
