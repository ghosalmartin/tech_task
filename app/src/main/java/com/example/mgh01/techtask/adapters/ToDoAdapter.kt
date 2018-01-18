package com.example.mgh01.techtask.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.viewholders.ToDoViewHolder

class ToDoAdapter(private val onDeletePressed: (Int) -> Unit) : RecyclerView.Adapter<ToDoViewHolder>() {

    private var results = mutableListOf<ToDoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder =
            ToDoViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.to_do_result_row, parent, false), {})

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(results[position], position)
    }

    fun update(results: List<ToDoItem>) {
        if (results.isEmpty()) return
        this.results.clear()
        this.results.addAll(results.toMutableList())
        notifyDataSetChanged()
    }

}
