package com.example.home.data.repository


import com.example.home.data.bookData.remote.BookListDto
import com.example.home.data.bookData.remote.api.BookApi
import com.example.home.data.vacancyData.remote.VacancyListDto
import com.example.home.data.vacancyData.remote.api.VacancyApi
import com.example.home.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val retrofit: Retrofit
): Repository {

    private val bookApi: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }

    private val vacancyApi: VacancyApi by lazy {
        retrofit.create(VacancyApi::class.java)
    }

    override suspend fun getBookList(): Flow<BookListDto> = flow {
        val result = bookApi.getNewestBooks()
        emit(result)
    }

    override suspend fun getVacancyList(): Flow<VacancyListDto> = flow {
        val result = vacancyApi.getVacancies()
        emit(result)
    }
}