package com.dicoding.todoapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel (private val taskRepository: TaskRepository) : ViewModel() {
    fun insertTask(title: String, description: String, dueDate: Long) {
        viewModelScope.launch {
            val task = Task(title = title, description = description, dueDateMillis = dueDate)
            taskRepository.insertTask(task)
        }
    }
}