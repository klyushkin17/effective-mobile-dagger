package com.example.home.data.vacancyData.remote

import com.squareup.moshi.Json

data class VacancyListDto(
    @field:Json(name = "vacancies") val vacancyList: List<VacancyDto>,
)