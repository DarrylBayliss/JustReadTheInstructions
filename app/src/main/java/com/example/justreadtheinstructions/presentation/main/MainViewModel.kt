package com.example.justreadtheinstructions.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justreadtheinstructions.domain.Launch
import com.example.justreadtheinstructions.usecases.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getLaunchesUseCase: GetLaunchesUseCase) : ViewModel() {

    private val _launches: MutableLiveData<List<Launch>> = MutableLiveData(emptyList())
    val launches: LiveData<List<Launch>> = _launches

    private val _error: MutableLiveData<Throwable> = MutableLiveData(null)
    val error: LiveData<Throwable> = _error

    fun getLaunches() {

        viewModelScope.launch {

            val getLaunchesResult = getLaunchesUseCase.call()

            if (getLaunchesResult.isSuccess) {
                val launches = getLaunchesResult.getOrNull()
                _launches.value = launches
            } else {
                val error = getLaunchesResult.exceptionOrNull()
                _error.value = error
            }
        }
    }
}