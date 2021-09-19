package com.example.justreadtheinstructions.data.launches

import com.example.justreadtheinstructions.data.SpaceXService
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(private val spaceXService: SpaceXService) :
    LaunchesRepository {

    override suspend fun getLaunches(): List<LaunchDTO> {
        return spaceXService.getLaunches()
    }
}