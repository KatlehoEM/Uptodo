/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a viewModel for the Task List screen, it contains
                        functions like the editTask,deleteTask and addTask
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1.ui.screens.todo_list

import androidx.lifecycle.ViewModel
import com.example.a2020102527_main_project_1.model.FirebaseStorageViewModel
import com.example.a2020102527_main_project_1.model.Task


class TaskListViewModel(
    private val tasksRepository: FirebaseStorageViewModel
) : ViewModel() {
    // Flow to expose the list of tasks
    val tasks = tasksRepository.state.value

    // Method to add a new task
    fun addTask(task: Task) {
        tasksRepository.addTask(task = task)
    }
    fun editTask(task: Task){
        tasksRepository.editTask(task = task)
    }

    fun deleteTask(task: Task){
        tasksRepository.deleteTask(task = task)
    }
    //This the function that handles the events from the Task Item
    fun onEvent(event: TaskListEvent){
        when(event){
            is TaskListEvent.OnAddTaskClick -> addTask(event.task)
            is TaskListEvent.OnMarkTaskDone -> {
                val updatedTask = event.task.copy(completed = event.completed)
                editTask(updatedTask)
            }
            is TaskListEvent.OnDeleteTaskClick -> deleteTask(event.task)
        }
    }
}
