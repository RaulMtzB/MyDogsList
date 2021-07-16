package com.rmb.mydoglist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rmb.mydoglist.domain.GetDogsByBreed
import com.rmb.mydoglist.model.Dog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val dogList = MutableLiveData<List<Dog>>()

    private val getDogsByBreed1 = GetDogsByBreed()

    fun getDogsByBreed(breed: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val dogs: List<Dog> = getDogsByBreed1(breed)

            dogList.postValue(dogs)
        }
    }
}