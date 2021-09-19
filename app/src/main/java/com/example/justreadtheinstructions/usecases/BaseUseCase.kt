package com.example.justreadtheinstructions.usecases

interface BaseUseCase<T> {
    suspend fun call(): T
}
