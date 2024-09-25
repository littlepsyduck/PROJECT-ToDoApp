package com.example.todoapp.Database.Category

import com.example.todoapp.Model.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun addCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun getCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }
}
