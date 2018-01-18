package com.example.mgh01.techtask.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.mgh01.techtask.extensions.load
import com.example.mgh01.techtask.extensions.openBrowser
import com.example.mgh01.techtask.models.GitHubUserSearchItem
import kotlinx.android.synthetic.main.github_search_result_tile.view.*


class GitHubUserTileViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(gitHubUserSearchItem: GitHubUserSearchItem) {

        view.run {
            github_search_result_avatar.load(gitHubUserSearchItem.avatarUrl)
            github_search_result_text.text = gitHubUserSearchItem.login
            setOnClickListener {
                gitHubUserSearchItem.url?.let {
                    context.openBrowser(it)
                }
            }
        }

    }
}