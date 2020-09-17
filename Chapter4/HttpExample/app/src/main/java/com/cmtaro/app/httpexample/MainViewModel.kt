package com.cmtaro.app.httpexample

import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel : ViewModel() {

    // (1)
    private val service: GitHubService by lazy {

        // (2)
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val moshiConverterFactory = MoshiConverterFactory.create(moshi)

        // (3)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(moshiConverterFactory)
            .build()
        retrofit.create(GitHubService::class.java)
    }

    fun listRepos() {
        viewModelScope.launch {
            try {
                // (1)
                val repos = service.listRepos("octocat", "created")
                repos.forEach {
                    Log.d(
                        "HTTPExample",
                        "fullName: ${it.fullName}, createdAt: ${it.createdAt}"
                    )
                }
                // (2)
            } catch (e: IOException) {
                Log.e("HTTPExample", "[Network Error] message: ${e.message}")
                // (3)
            } catch (e: HttpException) {
                Log.e("HTTPExample", "[API Error] code: ${e.code()}, message: ${e.message()}")
            }
        }
    }
}
