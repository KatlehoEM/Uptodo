/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This will be the startDestination for the NavHost
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1.ui.screens

import android.speech.RecognizerIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.a2020102527_main_project_1.R
import com.example.a2020102527_main_project_1.ui.theme.BlueK

// This Composable simply shows an image and two text images
@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "What do you want to do today?", fontSize = 23.sp)
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "home page image")
            Text(text = "Tab + to add your tasks", fontSize = 16.sp,color = BlueK)

        }
    }
}

@Preview
@Composable
fun HomePreview(){
    Home()
}