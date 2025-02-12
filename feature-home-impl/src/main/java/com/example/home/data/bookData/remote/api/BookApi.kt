package com.example.home.data.bookData.remote.api

import com.example.home.data.bookData.remote.BookListDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface BookApi {

    @GET
    suspend fun getNewestBooks(
        @Url url: String = "${BASE_URL}volumes",
        @Query("q") query: String = "a",
        @Query("maxResults") maxResults: Int = 20,
        @Query("orderBy") orderBy: String = "newest",
        @Query("key") apiKey: String = API_KEY
    ): BookListDto

    companion object {
        const val API_KEY = "AIzaSyCEsr9Jp8601qHaitM4CcYCXKV-ByawaBI"
        const val BASE_URL = "https://www.googleapis.com/books/v1/"
    }
}