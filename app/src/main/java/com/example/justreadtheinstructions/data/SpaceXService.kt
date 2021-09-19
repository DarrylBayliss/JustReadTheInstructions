package com.example.justreadtheinstructions.data

import com.example.justreadtheinstructions.data.launches.LaunchDTO
import retrofit2.http.GET

interface SpaceXService {

    @GET("v4/launches")
    suspend fun getLaunches(): List<LaunchDTO>
}