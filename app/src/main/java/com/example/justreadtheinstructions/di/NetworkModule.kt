package com.example.justreadtheinstructions.di

import com.example.justreadtheinstructions.data.SpaceXService
import com.example.justreadtheinstructions.data.launches.LaunchesRepository
import com.example.justreadtheinstructions.usecases.GetLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideSpaceXService(): SpaceXService {


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(SpaceXService::class.java)
    }
}