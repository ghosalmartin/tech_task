package com.example.mgh01.techtask.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import com.example.mgh01.techtask.adapters.GitHubSearchAdapter
import com.example.mgh01.techtask.models.GitHubUserSearchItem
import com.example.mgh01.techtask.presenters.GitHubUserSearchPresenter
import com.example.mgh01.techtask.utils.EqualSpacingItemDecoration
import com.example.mgh01.techtask.views.GitHubUserSearchView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.fragment_github_user_search.*

class GitHubUserSearchFragment : Fragment(), GitHubUserSearchView {

    private val adapter: GitHubSearchAdapter = GitHubSearchAdapter()

    private lateinit var presenter: GitHubUserSearchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_github_user_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = GitHubUserSearchPresenter(view = this)

        github_search_recyclerview.layoutManager = GridLayoutManager(context, 3)
        github_search_recyclerview.addItemDecoration(EqualSpacingItemDecoration(16, EqualSpacingItemDecoration.GRID))
        github_search_recyclerview.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.search()
    }

    override fun onPause() {
        presenter.tearDown()
        super.onPause()
    }

    override fun getSearchFlowable(): Flowable<String> =
            RxTextView.textChangeEvents(github_search_text_field)
                    .map { it.text().toString() }
                    .toFlowable(BackpressureStrategy.LATEST)

    override fun updateDataSet(results: List<GitHubUserSearchItem>?) {
        adapter.update(results)
    }

    override fun clearDataSet() {
        adapter.clear()
    }

    override fun displayError(message: String) {
        val builder = AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert)
        builder
                .setTitle(R.string.error_title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNegativeButton(getString(R.string.dimiss_button_text)) { dialog, _ ->
                    dialog.dismiss()
                }.show()
    }
}