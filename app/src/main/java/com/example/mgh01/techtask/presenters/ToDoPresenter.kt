package com.example.mgh01.techtask.presenters

import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.repositories.ToDoRepository
import com.example.mgh01.techtask.views.ToDoView
import io.reactivex.android.schedulers.AndroidSchedulers

class ToDoPresenter(private val view: ToDoView,
                    private val repo: ToDoRepository = ToDoRepository()) {

    fun getToDos() {
        repo.getAllToDos().subscribeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    view.initializeData(it)
                },
                {
                    it.printStackTrace()
                })
    }

    fun insertToDo(toDo: String) {
        repo.insertToDo(ToDoItem(item = toDo))
    }

    fun deleteToDo(toDo: ToDoItem?) {
        repo.deleteToDo(toDo)
    }

}