package com.example.mgh01.techtask.services

import com.example.mgh01.techtask.models.GitHubUserSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    @GET("search/users")
    fun searchForUser(@Query("q") searchTerms: String): Single<GitHubUserSearchResponse>

}