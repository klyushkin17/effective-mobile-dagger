package com.example.home.data.bookData.remote

import com.squareup.moshi.Json

data class BookDto (
    @field:Json(name = "id") val bookId: String,
    @field:Json(name = "volumeInfo") val volumeInfo: VolumeInfoDto,
)

data class VolumeInfoDto(
    @field:Json(name = "title") val title: String,
)

