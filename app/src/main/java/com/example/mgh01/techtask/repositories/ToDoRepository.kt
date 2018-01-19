package com.example.mgh01.techtask.repositories

import com.example.mgh01.techtask.models.ToDoItem
import io.reactivex.Flowable
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.deleteFromRealm

class ToDoRepository(private val service: Realm = Realm.getDefaultInstance()) {

    fun getAllToDos(): Flowable<RealmResults<ToDoItem>> =
            service.where(ToDoItem::class.java).findAll().asFlowable()

    fun insertToDo(toDoItem: ToDoItem) {
        service.beginTransaction()
        val localToDoItem = service.createObject(ToDoItem::class.java, toDoItem.id)
        localToDoItem.item = toDoItem.item
        service.commitTransaction()
    }


    fun deleteToDo(toDoItem: ToDoItem?) {
        service.beginTransaction()
        toDoItem?.deleteFromRealm()
        service.commitTransaction()
    }

}