package com.example.mgh01.techtask.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.mgh01.techtask.models.ToDoItem
import kotlinx.android.synthetic.main.to_do_result_row.view.*

class ToDoViewHolder(private val view: View,
                     private val onClick: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bind(toDoItem: ToDoItem, position: Int) {
        view.run {
            to_do_text.text = toDoItem.todo
            to_do_remove.setOnClickListener {
                onClick.invoke(position)
            }
        }
    }
}