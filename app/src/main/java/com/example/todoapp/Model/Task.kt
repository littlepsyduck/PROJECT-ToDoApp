package com.example.todoapp.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tasks",
    indices = [Index(value = ["userId"]), Index(value = ["categoryId"])],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Task(
    val title: String,
    val description: String?,
    val dueDate: String?,
    val status: String,
    val categoryId: Int,
    val userId: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
