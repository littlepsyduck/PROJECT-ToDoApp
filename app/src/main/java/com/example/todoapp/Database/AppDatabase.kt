package com.example.todoapp.Database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.Model.Task
import com.example.todoapp.Model.User
import com.example.todoapp.Database.Category.CategoryDao
import com.example.todoapp.Database.Task.TaskDao
import com.example.todoapp.Database.User.UserDao
import com.example.todoapp.Model.Category

@Database(entities = [User::class, Task::class, Category::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUserDao() : UserDao
    abstract fun getTaskDao() : TaskDao
    abstract fun getCategoryDao() : CategoryDao

    companion object {
        @Volatile
        private var database_name = "todo_database"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    database_name
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}