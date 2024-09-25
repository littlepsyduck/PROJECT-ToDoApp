package com.example.todoapp.Database.Task

import com.example.todoapp.Model.Task

class TaskRepository(private val taskDao: TaskDao) {
    suspend fun addTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun getTasks(userId: Int): List<Task> {
        return taskDao.getTasksByUserId(userId)
    }

    suspend fun getTask(taskId: Int): Task? {
        return taskDao.getTaskById(taskId)
    }
}
