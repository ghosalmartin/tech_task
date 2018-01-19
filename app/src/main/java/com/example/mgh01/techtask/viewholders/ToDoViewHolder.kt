package com.example.mgh01.techtask.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.to_do_result_row.view.*

class ToDoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(toDoItem: String, removeAction: () -> Unit) {
        view.run {
            to_do_text.text = toDoItem
            to_do_remove.setOnClickListener {
                removeAction()
            }
        }
    }
}