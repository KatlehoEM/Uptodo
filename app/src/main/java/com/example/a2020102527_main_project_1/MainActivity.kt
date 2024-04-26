/*
  Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is main activity for the App
    Date: 09 April 2024
    Module Code: CSIP6853
*/
package com.example.a2020102527_main_project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2020102527_main_project_1.ui.screens.bottom_appbar.MyBottomAppBar
import com.example.a2020102527_main_project_1.ui.theme._2020102527_Main_Project_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2020102527_Main_Project_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyBottomAppBarPreview() {
    _2020102527_Main_Project_1Theme {
        MyBottomAppBar()
    }
}