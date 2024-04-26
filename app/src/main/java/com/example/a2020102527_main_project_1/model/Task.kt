/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a data class that will define the object for all Tasks
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.model

import com.google.firebase.firestore.DocumentId

data class Task(
    @DocumentId val id: String = "", // @DocumentId is set to automatically increment when a new task is added
    val title: String  = "",
    val description: String = "",
    val completed: Boolean = false
)