package com.example.mgh01.techtask.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import com.example.mgh01.techtask.models.ToDoItem
import com.example.mgh01.techtask.viewholders.ToDoViewHolder
import com.example.mgh01.techtask.views.ToDoView
import io.realm.OrderedCollectionChangeSet
import io.realm.OrderedRealmCollectionChangeListener
import io.realm.RealmResults

class ToDoAdapter(private var results: RealmResults<ToDoItem>,
                  private val toDoView: ToDoView) : RecyclerView.Adapter<ToDoViewHolder>(), OrderedRealmCollectionChangeListener<RealmResults<ToDoItem>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder =
            ToDoViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.to_do_result_row, parent, false))

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(results[position]?.item.orEmpty(), { toDoView.deleteToDo(results[position]) })
    }

    override fun onChange(t: RealmResults<ToDoItem>?, changeSet: OrderedCollectionChangeSet?) {
        notifyDataSetChanged()
    }

}
