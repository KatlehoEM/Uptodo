/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a composable to show the events on the calendar however for this
                        part of the project, it will not be implemented in full.
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.a2020102527_main_project_1.R
import com.example.a2020102527_main_project_1.ui.theme.BlueK

@Composable
fun Calendar(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.calendar), contentDescription = "events page")
            Text(text = "Currently, there are no events scheduled", fontSize = 18.sp, color = BlueK)
        }
    }
}
