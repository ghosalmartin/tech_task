package com.example.mgh01.techtask.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GitHubUserSearchItem(val login: String? = null,
                                @JsonProperty("html_url") val url: String? = null,
                                @JsonProperty("avatar_url") val avatarUrl: String? = "")