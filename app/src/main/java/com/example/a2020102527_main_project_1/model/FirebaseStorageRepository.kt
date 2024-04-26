/*
    Surname and Initials: Makhooane KE
    Student Number: 2020102527
    Purpose of code: This is a repository that fetches data from the FireStore
    Date: 09 April 2024
    Module Code: CSIP6853
*/

package com.example.a2020102527_main_project_1.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class FirebaseStorageViewModel : ViewModel() {
    val state = mutableStateOf<List<Task>>(emptyList())

    init {
        getAllTasks()
    }
    //This function is used to store the database tasks as a state for use in screens
    fun getAllTasks() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
    //This function adds Tasks into the firestore database
    fun addTask(task: Task) {
        viewModelScope.launch {
            val db = Firebase.firestore // The instance of the firestore database
            try {
                db.collection("tasks").add(task).await()

            } catch(e: FirebaseFirestoreException){
                Log.d("error","getDataFromFireStore: $e")
            }
        }
    }
    //The function that updates the edited task in the firestore database
    fun editTask(task: Task) {
        viewModelScope.launch {
            val db = Firebase.firestore
            try {
                db.collection("tasks").document(task.id).set(task).await()
                getAllTasks() // Refresh the list after editing a task
            } catch(e: FirebaseFirestoreException){
                Log.d("error","getDataFromFireStore: $e")
            }
        }
    }
    //This function deletes a selected task from the firestore database
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            val db = Firebase.firestore
            try {
                db.collection("tasks").document(task.id).delete().await()
                getAllTasks() // Refresh the list after deleting a task
            } catch(e: FirebaseFirestoreException){
                Log.d("error","getDataFromFireStore: $e")
            }
        }
    }
    //This is a function that retrieves documents from the firestore database
    private suspend fun getDataFromFireStore(): List<Task> {
        val db = Firebase.firestore
        val tasks = mutableListOf<Task>()
        try {
            val querySnapshot: QuerySnapshot = db.collection("tasks").get().await()
            for (document in querySnapshot.documents) {
                val task = document.toObject(Task::class.java)
                task?.let {
                    tasks.add(it)
                }
            }
        } catch(e: FirebaseFirestoreException){
            Log.d("error","getDataFromFireStore: $e")
        }
        return tasks
    }
}
