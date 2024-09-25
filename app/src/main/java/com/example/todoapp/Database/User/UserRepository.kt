package com.example.todoapp.Database.User

import com.example.todoapp.Model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun addUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUser(userId: Int): User? {
        return userDao.getUserById(userId)
    }
}
