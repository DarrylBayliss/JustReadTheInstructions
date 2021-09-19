package com.example.justreadtheinstructions.di

import com.example.justreadtheinstructions.data.launches.LaunchesRepository
import com.example.justreadtheinstructions.data.launches.LaunchesRepositoryImpl
import com.example.justreadtheinstructions.usecases.GetLaunchesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindLaunchesRepository(launchesRepositoryImpl: LaunchesRepositoryImpl): LaunchesRepository
}