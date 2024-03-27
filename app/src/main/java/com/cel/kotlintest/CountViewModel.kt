package com.cel.kotlintest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.value = 0
    }
    fun setInitialCount(initialCount: Int) {
        _count.value = initialCount
    }
    fun incrementCount() {
        CoroutineScope(Dispatchers.Main).launch {
            _count.value = _count.value?.plus(1)
        }
    }
}
