package com.rmb.mydoglist.data.network

import com.rmb.mydoglist.model.Dog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiClient {
    @GET("{breed}/images")
    suspend fun getDogsByBreed(@Path("breed") breed: String): Response<DogsResponse>
}