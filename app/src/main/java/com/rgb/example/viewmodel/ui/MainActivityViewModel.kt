package com.rgb.example.viewmodel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(initialSum: Int) : ViewModel() {
    private var sum = MutableLiveData<Int>()

    // Read-only version of sum (Immutable type)
    val sumData: LiveData<Int>
        get() = sum

    var input: String = "0"
        get() = if (field.isEmpty()) "0" else field

    init {
        sum.value = initialSum
    }

    fun updateSum() {
        sum.value = sum.value?.plus(input.toInt()) ?: 0
    }
}