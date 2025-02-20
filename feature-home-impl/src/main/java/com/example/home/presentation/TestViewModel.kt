package com.example.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.home.data.bookData.remote.BookDto
import com.example.home.data.vacancyData.remote.VacancyDto
import com.example.home.domain.repository.Repository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

const val TAG = "HAHAH"

@Suppress("UNCHECKED_CAST")
class TestViewModel(
    private val dataId: String,
    private val repository: Repository
): ViewModel() {

    private var _bookListState = MutableStateFlow<List<BookDto>>(emptyList())
    val bookListState = _bookListState.asStateFlow()

    private var _vacancyListState = MutableStateFlow<List<VacancyDto>>(emptyList())
    val vacancyListState = _vacancyListState.asStateFlow()

    init {
        Log.d(TAG, dataId)
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

    class TestViewModelFactory @AssistedInject constructor(
        @Assisted("dataId") private val dataId: String,
        private val repository: Repository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TestViewModel(dataId, repository) as T
        }

        @AssistedFactory
        interface Factory {

            fun create(@Assisted("dataId") dataId: String): TestViewModelFactory
        }
    }
}