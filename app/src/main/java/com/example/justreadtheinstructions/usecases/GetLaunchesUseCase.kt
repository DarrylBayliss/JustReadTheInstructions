package com.example.justreadtheinstructions.usecases

import android.net.Uri
import com.example.justreadtheinstructions.data.launches.LaunchesRepository
import com.example.justreadtheinstructions.data.launches.LaunchesRepositoryImpl
import com.example.justreadtheinstructions.domain.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(private val launchesRepository: LaunchesRepository) :
    BaseUseCase<Result<List<Launch>>> {

    override suspend fun call(): Result<List<Launch>> {

        return withContext(Dispatchers.IO) {

            try {
                val launches = launchesRepository
                    .getLaunches()
                    .map { launchDTO ->

                        val imageUri = if (launchDTO.links.patch.large != null) {
                            Uri.parse(launchDTO.links.patch.large)
                        } else {
                            null
                        }

                        val webcastUri = if (launchDTO.links.webcast != null) {
                            Uri.parse(launchDTO.links.webcast)
                        } else {
                            null
                        }

                        Launch(
                            launchDTO.name,
                            launchDTO.date,
                            launchDTO.details,
                            imageUri,
                            webcastUri
                        )
                    }

                Result.success(launches)
            } catch (error: Error) {
                Result.failure(error)
            }
        }
    }
}