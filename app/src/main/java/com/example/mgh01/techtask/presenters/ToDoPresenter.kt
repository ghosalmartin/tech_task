package com.example.mgh01.techtask.presenters

import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.repositories.ToDoRepository
import com.example.mgh01.techtask.views.ToDoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class ToDoPresenter(private val view: ToDoView,
                    private val repo: ToDoRepository = ToDoRepository()) {

    private var disposable: Disposable? = null

    fun getToDos() {
        disposable?.dispose()
        disposable = repo.getAllToDos().subscribeOn(AndroidSchedulers.mainThread()).subscribe(
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

    fun tearDown() {
        disposable?.dispose()
    }

}