package com.example.mgh01.techtask.repositories

import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.models.ToDoItems
import io.paperdb.Book
import io.paperdb.Paper
import io.reactivex.Single

class ToDoRepository(private val service: Book = Paper.book()) {

    companion object {
        private const val TO_DO_KEY = "TO_DO_KEY"
    }

    fun getAllToDos(): Single<ToDoItems> =
            Single.just(service.read<Pair<Long, ToDoItems>>(TO_DO_KEY, Pair(0, ToDoItems())).second)


    fun insertToDo(toDoItem: ToDoItem): Single<List<ToDoItem>> =
            getAllToDos().flatMap {
                val updatedItem = it.items.plus(toDoItem)
                service.write(TO_DO_KEY, Pair(0, updatedItem))
                Single.just(updatedItem)

            }


    fun deleteToDo(position: Int): Single<List<ToDoItem>> =
            getAllToDos().flatMap {
                val updatedItem = it.items.drop(position)
                service.write(TO_DO_KEY, updatedItem)
                Single.just(updatedItem)
            }


}