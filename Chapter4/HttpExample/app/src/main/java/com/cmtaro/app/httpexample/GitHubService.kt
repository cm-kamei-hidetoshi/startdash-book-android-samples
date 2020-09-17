package com.cmtaro.app.httpexample

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// (1)
interface GitHubService {

    // (2)
    @GET("users/{user}/repos")
    suspend fun listRepos(
        @Path("user") user: String,
        @Query("sort") sort: String
    ): List<Repo>
}
