package com.example.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.home.data.bookData.remote.BookDto
import com.example.home.data.vacancyData.remote.VacancyDto
import com.example.home.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "HAHAH"

@Suppress("UNCHECKED_CAST")
class TestViewModel(private val repository: Repository): ViewModel() {

    private var _bookListState = MutableStateFlow<List<BookDto>>(emptyList())
    val bookListState = _bookListState.asStateFlow()

    private var _vacancyListState = MutableStateFlow<List<VacancyDto>>(emptyList())
    val vacancyListState = _vacancyListState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBookList().collect { newBookList ->
                _bookListState.value = newBookList.bookList ?: emptyList()
                Log.d(TAG, bookListState.value.toString())
            }

            repository.getVacancyList().collect { newVacancyList ->
                _vacancyListState.value = newVacancyList.vacancyList
                Log.d(TAG, vacancyListState.value.toString())
            }
        }
    }

    class TestViewModelFactory @Inject constructor(
        private val repository: Repository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TestViewModel(repository) as T
        }
    }
}