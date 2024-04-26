/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This Kotlin file contains composables that make up the BottomAppBar such as:
                       MyBottomAppBar,BottomAppBarIcon, BottomAppBarContent

    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.bottom_appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a2020102527_main_project_1.Screens
import com.example.a2020102527_main_project_1.model.FirebaseStorageViewModel
import com.example.a2020102527_main_project_1.ui.screens.Calendar
import com.example.a2020102527_main_project_1.ui.screens.Home
import com.example.a2020102527_main_project_1.ui.screens.Profile
import com.example.a2020102527_main_project_1.ui.screens.add_edit_todo.AddEditTaskScreen
import com.example.a2020102527_main_project_1.ui.screens.todo_list.TaskListScreen
import com.example.a2020102527_main_project_1.ui.screens.todo_list.TaskListViewModel
import com.example.a2020102527_main_project_1.ui.screens.todo_list.Tasks
import com.example.a2020102527_main_project_1.ui.theme.BlueK

@Composable
fun BottomAppBarIcon(
    icon: ImageVector,
    text: String,
    selected: Boolean,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(26.dp),
            tint = if (selected) Color.White else Color.DarkGray
        )

        Text(text = text,
            fontSize = 11.sp,
            color = if (selected) Color.White else Color.DarkGray
        )
    }
}


@Composable
fun BottomAppBarContent(
    selected: MutableState<ImageVector>,
    navigationController: NavHostController
) {
    BottomAppBar(
        containerColor = BlueK
    ) {
        IconButton(
            onClick = {
                selected.value = Icons.Default.Home
                navigationController.navigate(Screens.Home.screen) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            BottomAppBarIcon(
                icon = Icons.Default.Home,
                text = "Home",
                selected = selected.value == Icons.Default.Home
            )
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.DateRange
                navigationController.navigate(Screens.Calendar.screen) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            BottomAppBarIcon(
                icon = Icons.Default.DateRange,
                text = "Calendar",
                selected = selected.value == Icons.Default.DateRange
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FloatingActionButton(onClick = {navigationController.navigate(Screens.AddEditTodoScreen.screen) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = BlueK,
                    modifier = Modifier.size(26.dp)
                )

            }
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.Menu
                navigationController.navigate(Screens.TaskListScreen.screen) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            BottomAppBarIcon(
                icon = Icons.Default.Menu,
                text = "Tasks",
                selected = selected.value == Icons.Default.Menu
            )
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.Person
                navigationController.navigate(Screens.Profile.screen) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            BottomAppBarIcon(
                icon = Icons.Default.Person,
                text = "Profile",
                selected = selected.value == Icons.Default.Person
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(
    viewModel: BottomAppBarViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigationController: NavHostController = rememberNavController(),
    firebaseViewModel: FirebaseStorageViewModel = FirebaseStorageViewModel()
) {
    val selectedIcon = viewModel.selectedIcon
    val taskListViewModel = TaskListViewModel(firebaseViewModel) // Instantiate tasksviewModel and pass the database repository
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "UpTodo", fontSize = 30.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BlueK, titleContentColor = Color.White)
            )
        },
        bottomBar = {
            BottomAppBarContent(
                selected = selectedIcon,
                navigationController = navigationController
            )
        }
    ) { paddingValues ->
        NavHost(
            // This Section is the NavHost for this App
            navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { Home() }
            composable(Screens.Tasks.screen) { Tasks() }
            composable(Screens.Calendar.screen) { Calendar() }
            composable(Screens.Profile.screen) { Profile() }
            composable(route = Screens.AddEditTodoScreen.screen,
                content = {
                    AddEditTaskScreen(taskListViewModel = taskListViewModel, navController = navigationController)
                })
            composable(route = Screens.TaskListScreen.screen,
                content = {
                    TaskListScreen(viewModel = taskListViewModel, navController = navigationController)
                })
        }
    }
}