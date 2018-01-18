package com.example.mgh01.techtask.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import com.example.mgh01.techtask.models.GitHubUserSearchItem
import com.example.mgh01.techtask.viewholders.GitHubUserTileViewHolder

class GitHubSearchAdapter : RecyclerView.Adapter<GitHubUserTileViewHolder>() {

    private var results = mutableListOf<GitHubUserSearchItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserTileViewHolder =
            GitHubUserTileViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.github_search_result_tile, parent, false))

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: GitHubUserTileViewHolder, position: Int) {
        holder.bind(results[position])
    }

    fun update(results: List<GitHubUserSearchItem>?) {
        if (results == null || results.isEmpty()) return
        this.results.clear()
        this.results.addAll(results.toMutableList())
        notifyDataSetChanged()
    }

    fun clear() {
        results.clear()
        notifyDataSetChanged()
    }
}