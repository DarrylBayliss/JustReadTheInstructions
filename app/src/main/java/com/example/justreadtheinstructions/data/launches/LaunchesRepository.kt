package com.example.justreadtheinstructions.data.launches

interface LaunchesRepository {

    suspend fun getLaunches() : List<LaunchDTO>
}