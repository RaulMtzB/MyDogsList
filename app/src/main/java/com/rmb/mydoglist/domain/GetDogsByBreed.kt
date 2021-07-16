package com.rmb.mydoglist.domain

import com.rmb.mydoglist.data.DogRepository
import com.rmb.mydoglist.model.Dog

class GetDogsByBreed {
    private val repository = DogRepository()

    suspend operator fun invoke(breed: String): List<Dog> {
        return repository.getDogsByBreed(breed)
    }
}