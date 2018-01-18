package com.example.mgh01.techtask.views

import com.example.mgh01.techtask.models.ToDoItem

interface ToDoView {
    fun updateToDos(toDoItems: List<ToDoItem>)
}