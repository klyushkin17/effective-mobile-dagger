package com.example.home.data.vacancyData.remote.api


import com.example.home.data.vacancyData.remote.VacancyListDto
import retrofit2.http.GET

interface VacancyApi {

    @GET("vacancies.json")
    suspend fun getVacancies(): VacancyListDto
}