package com.example.mgh01.techtask.presenters

import com.example.mgh01.techtask.extensions.onDefaultSchedulers
import com.example.mgh01.techtask.repositories.GitHubRepository
import com.example.mgh01.techtask.views.GitHubUserSearchView
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class GitHubUserSearchPresenter(private val repo: GitHubRepository = GitHubRepository(),
                                private val view: GitHubUserSearchView){

    private var disposable: Disposable? = null

    fun search(){
        disposable = view.getSearchFlowable()
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter{
                    it.isNotBlank()
                }
                .flatMapSingle {
                    repo.searchForUsers(it)
                }
                .onDefaultSchedulers()
                .subscribe({
                    view.updateDataSet(it.items)
                },{
                    it.printStackTrace()
                })
    }

    fun tearDown() {
        disposable?.dispose()
    }


}