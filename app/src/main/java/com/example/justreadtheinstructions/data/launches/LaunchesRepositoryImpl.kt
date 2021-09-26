package com.example.justreadtheinstructions.data.launches

import com.example.justreadtheinstructions.data.SpaceXService
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(private val spaceXService: SpaceXService) :
    LaunchesRepository {

    override suspend fun getLaunches(): List<LaunchDTO> {
        return spaceXService
            .getLaunches()
            .reversed() // SpaceX API returns the earliest launches first, this changes the order so the most recent launches come first
    }
}