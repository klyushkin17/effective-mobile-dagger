package com.example.home.data.bookData.remote

import com.squareup.moshi.Json

data class BookListDto(
    @field:Json(name = "items") val bookList: List<BookDto>?,
    @field:Json(name = "totalItems") val countItems: Int
)
