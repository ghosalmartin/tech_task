package com.example.mgh01.techtask.repositories

import com.example.mgh01.techtask.services.GitHubService
import com.example.mgh01.techtask.utils.BuildConstants
import com.example.mgh01.techtask.utils.Network

class GitHubRepository(private val service: GitHubService = Network.createService(GitHubService::class.java, BuildConstants.GITHUB_BASE_URL)) {

    fun searchForUsers(searchTerm: String) = service.searchForUser(searchTerm)

}