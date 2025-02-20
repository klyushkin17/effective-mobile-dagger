package com.example.home.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home.di.HomeComponent
import com.example.home.di.HomeDependenciesProvider
import javax.inject.Inject


class TestFragment : Fragment() {

    private val dataId = "SomeId"
    private val testViewModel: TestViewModel by viewModels {
        testViewModelFactoryFactory.create(dataId)
    }

    @Inject
    lateinit var testViewModelFactoryFactory: TestViewModel.TestViewModelFactory.Factory

    override fun onAttach(context: Context) {
        HomeComponent.init(requireContext().applicationContext as HomeDependenciesProvider)
            .injectIntoTestFragment(this)
        testViewModel
        super.onAttach(context)
    }
}