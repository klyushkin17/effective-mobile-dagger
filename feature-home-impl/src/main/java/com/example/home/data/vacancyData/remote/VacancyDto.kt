package com.example.home.data.vacancyData.remote

import com.squareup.moshi.Json

data class VacancyDto(
    @field:Json(name = "id") val vacancyId: String,
    @field:Json(name = "title") val vacancyTitle: String,
)



