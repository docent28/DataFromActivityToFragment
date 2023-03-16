package com.example.datafromactivitytofragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageForOneFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForTwoFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}