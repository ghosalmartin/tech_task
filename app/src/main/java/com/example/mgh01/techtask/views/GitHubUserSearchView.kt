package com.example.mgh01.techtask.views

import com.example.mgh01.techtask.models.GitHubUserSearchItem
import io.reactivex.Flowable

interface GitHubUserSearchView{
    fun getSearchFlowable(): Flowable<String>
    fun updateDataSet(results : List<GitHubUserSearchItem>?)
    fun clearDataSet()
    fun displayError(message: String)
}