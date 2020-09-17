package com.cmtaro.app.httpexample

import com.squareup.moshi.Json

data class Repo(

    @Json(name = "full_name")
    val fullName: String,

    @Json(name = "created_at")
    val createdAt: String
)
