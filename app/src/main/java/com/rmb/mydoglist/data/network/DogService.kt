package com.rmb.mydoglist.data.network

import com.rmb.mydoglist.core.RetrofitHelper
import com.rmb.mydoglist.model.Dog

class DogService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDogsByBreed(breed: String): List<Dog> {
        val dogs = mutableListOf<Dog>()
        val response = retrofit.create(DogApiClient::class.java).getDogsByBreed(breed)

        if(response.body() != null) {
            response.body()!!.images.forEach {
                dogs.add(Dog(it))
            }
        }

        return dogs
    }
}