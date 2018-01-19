package com.example.mgh01.techtask.views

import com.example.mgh01.techtask.models.ToDoItem
import io.realm.RealmResults

interface ToDoView {
    fun initializeData(toDoItems: RealmResults<ToDoItem>)
    fun deleteToDo(toDoItem: ToDoItem?)
}