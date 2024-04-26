/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a class for the events that may be triggered by changes to the task items
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1.ui.screens.todo_list

import com.example.a2020102527_main_project_1.model.Task

sealed class TaskListEvent {
    data class OnDeleteTaskClick(val task: Task) : TaskListEvent()
    data class OnMarkTaskDone(val task: Task, val completed: Boolean) : TaskListEvent()
    data class OnAddTaskClick(val task: Task) : TaskListEvent()
}
