/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is the AddEdit ViewModel for adding/editing tasks
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.ui.screens.add_edit_todo

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

// Definition fo the  AddEdit ViewModel
class AddEditTaskViewModel : ViewModel() {
    val title = mutableStateOf(TextFieldValue())
    val description = mutableStateOf(TextFieldValue())
}