package com.example.home.data.vacancyData.remote.api


import com.example.home.data.vacancyData.remote.VacancyListDto
import retrofit2.http.GET
import retrofit2.http.Url

interface VacancyApi {
    @GET
    suspend fun getVacancies(
        @Url url: String = "${BASE_URL}vacancies.json"
    ): VacancyListDto

    companion object {
        const val BASE_URL = "https://klyushkin17.github.io/hh-api/"
    }
}