package com.example.home.domain.repository

import com.example.home.data.bookData.remote.BookListDto
import com.example.home.data.vacancyData.remote.VacancyListDto
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getBookList(): Flow<BookListDto>

    suspend fun getVacancyList(): Flow<VacancyListDto>
}