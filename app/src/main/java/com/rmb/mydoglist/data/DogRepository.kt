package com.rmb.mydoglist.data

import com.rmb.mydoglist.data.network.DogService
import com.rmb.mydoglist.model.Dog

class DogRepository {
    private val dogService = DogService()

    suspend fun getDogsByBreed(breed: String): List<Dog> {
        return dogService.getDogsByBreed(breed)
    }
}