/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is the AddEditTaskScreen composable for adding/editing tasks
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.add_edit_todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a2020102527_main_project_1.Screens
import com.example.a2020102527_main_project_1.model.FirebaseStorageViewModel
import com.example.a2020102527_main_project_1.model.Task
import com.example.a2020102527_main_project_1.ui.screens.todo_list.TaskListViewModel
import com.example.a2020102527_main_project_1.ui.theme.BlueK
import kotlinx.coroutines.launch


@Composable
fun AddEditTaskScreen(
    taskListViewModel: TaskListViewModel = TaskListViewModel(FirebaseStorageViewModel()),
    navController: NavHostController
) {
    val addEditViewModel = viewModel<AddEditTaskViewModel>()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Launching a coroutine so that the operations that come after are suspended
                    scope.launch{
                        taskListViewModel.addTask(
                            Task(
                                title = addEditViewModel.title.value.text,
                                description = addEditViewModel.description.value.text,
                                completed = false
                            )
                        )

                    }
                    navController.navigate(Screens.TaskListScreen.screen) //navigates to TaskList screen
                },
                containerColor = BlueK
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save",

                    )
            }
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                label = { Text(text = "Title") },
                value = addEditViewModel.title.value,
                onValueChange = { addEditViewModel.title.value = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Handle Done button press
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            val localFocusManager = LocalFocusManager.current
            OutlinedTextField(
                label = { Text(text = "Description") },
                value = addEditViewModel.description.value,
                onValueChange = { addEditViewModel.description.value = it },
                maxLines = 5,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions{
                    localFocusManager.clearFocus()
                },
                modifier = Modifier.fillMaxWidth().padding(paddingValues)
            )
        }
    }
}

@Preview
@Composable
fun AddEditTodoScreenPreview() {
    //AddEditTodoScreen()
}
