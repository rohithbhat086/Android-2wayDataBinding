package com.rgb.example.viewmodel.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private var initialSum: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(initialSum) as T
        }
        throw IllegalArgumentException("Invalid viewmodel class")
    }
}