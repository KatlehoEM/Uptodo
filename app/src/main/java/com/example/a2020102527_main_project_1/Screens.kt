/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a class that contains all the routes for the screens in this App
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1

sealed class Screens(val screen: String) {
    data object Home: Screens("home")
    data object Tasks: Screens("tasks")
    data object Calendar: Screens("calendar")
    data object Profile: Screens("profile")
    data object AddEditTodoScreen: Screens("add_edit_todo")
    data object TaskListScreen: Screens("task_list")
}