package com.example.mgh01.techtask.presenters

import com.example.mgh01.techtask.extensions.onDefaultSchedulers
import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.repositories.ToDoRepository
import com.example.mgh01.techtask.views.ToDoView

class ToDoPresenter(private val view: ToDoView,
                    private val repo: ToDoRepository = ToDoRepository()) {

    fun getToDos() {
        repo.getAllToDos()
                .onDefaultSchedulers()
                .subscribe { success, failure ->
                    success?.let {
                        it.items?.let {
                            view.updateToDos(it)
                        }
                    }

                    failure?.let {
                        it.printStackTrace()
                    }
                }
    }

    fun insertToDo(toDo: String) {
        repo.insertToDo(ToDoItem(toDo))
                .onDefaultSchedulers()
                .subscribe { success, failure ->
                    success?.let {
                        view.updateToDos(it)
                    }

                }
    }

    fun deleteToDo(position: Int) {
        repo.deleteToDo(position)
                .onDefaultSchedulers()
                .subscribe { success, failure ->
                    success?.let {
                        view.updateToDos(it)
                    }
                }
    }

}