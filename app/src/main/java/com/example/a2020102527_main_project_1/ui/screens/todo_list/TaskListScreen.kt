/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This Kotlin file contains the composable to show the list if tasks
                    through a lazy column

    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.todo_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a2020102527_main_project_1.Screens
import com.example.a2020102527_main_project_1.model.FirebaseStorageViewModel
import com.example.a2020102527_main_project_1.model.Task


@Composable
fun TaskListScreen(
    viewModel: TaskListViewModel = TaskListViewModel(FirebaseStorageViewModel()),
    navController: NavHostController
){
    val tasks = viewModel.tasks

    // Check if the task list is empty
    if (tasks.isEmpty()) {
        // Navigate to the "EmptyList" screen
        navController.navigate(Screens.Tasks.screen)
    } else {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(tasks){task ->
                TaskItem(
                    task = task,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screens.AddEditTodoScreen.screen)
                        }
                        .padding(8.dp)
                )
            }
        }
    }

}

