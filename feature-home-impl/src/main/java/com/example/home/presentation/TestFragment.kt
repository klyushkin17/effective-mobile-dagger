package com.example.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.home.di.HomeComponent
import javax.inject.Inject


class TestFragment : Fragment() {

    @Inject
    lateinit var testViewModelFactory: TestViewModel.TestViewModelFactory

    private lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.init(requireContext()).injectIntoTestFragment(this)

        testViewModel = ViewModelProvider(this, testViewModelFactory)[TestViewModel::class.java]
    }
}