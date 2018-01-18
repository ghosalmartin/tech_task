package com.example.mgh01.techtask.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import com.example.mgh01.techtask.adapters.ToDoAdapter
import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.presenters.ToDoPresenter
import com.example.mgh01.techtask.utils.EqualSpacingItemDecoration
import com.example.mgh01.techtask.views.ToDoView
import kotlinx.android.synthetic.main.fragment_todo.*

class ToDoFragment : Fragment(), ToDoView {

    private val onDeletePressed: (Int) -> Unit = { position ->
        presenter.deleteToDo(position)
    }
    private val adapter = ToDoAdapter(onDeletePressed)

    private lateinit var presenter: ToDoPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_todo, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ToDoPresenter(view = this)
        presenter.getToDos()

        todo_search_recycler_view.layoutManager = GridLayoutManager(context, 3)
        todo_search_recycler_view.addItemDecoration(EqualSpacingItemDecoration(16, EqualSpacingItemDecoration.GRID))
        todo_search_recycler_view.adapter = adapter

        to_do_add.setOnClickListener {
            insertToDo()
        }

    }

    private fun insertToDo() {
        presenter.insertToDo(github_search_text_field.text.toString())
    }

    override fun updateToDos(toDoItems: List<ToDoItem>) {
        adapter.update(toDoItems)
    }

}