/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a composable for the Task item which will be use in the TaskList screen
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2020102527_main_project_1.model.Task


@Composable
fun TaskItem(
    task: Task,
    onEvent: (TaskListEvent) -> Unit, //This event is passed that the composable
    // is aware of any change to the task
    modifier: Modifier = Modifier
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier.padding(1.dp,0.dp,8.dp,1.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Checkbox(
                checked = task.completed,
                onCheckedChange = { isChecked ->
                    onEvent(TaskListEvent.OnMarkTaskDone(task, isChecked))
                }
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, style = MaterialTheme.typography.titleLarge)
                CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
                    Text(text = task.description,fontSize = 14.sp)

                }
            }
            IconButton(
                onClick = {
                    onEvent(TaskListEvent.OnDeleteTaskClick(task))
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )

            }
        }
    }
}


