package com.example.home.data.bookData.remote.api

import com.example.home.data.bookData.remote.BookListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("volumes")
    suspend fun getNewestBooks(
        @Query("q") query: String = "a",
        @Query("maxResults") maxResults: Int = 20,
        @Query("orderBy") orderBy: String = "newest",
        @Query("key") apiKey: String = API_KEY
    ): BookListDto

    companion object {
        const val API_KEY = "AIzaSyCEsr9Jp8601qHaitM4CcYCXKV-ByawaBI"
    }
}