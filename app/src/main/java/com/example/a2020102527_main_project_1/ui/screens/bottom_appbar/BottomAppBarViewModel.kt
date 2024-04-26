/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is the ViewModel for the BottomAppBar
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.bottom_appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BottomAppBarViewModel: ViewModel(){
    val selectedIcon = mutableStateOf(Icons.Default.Home)
}