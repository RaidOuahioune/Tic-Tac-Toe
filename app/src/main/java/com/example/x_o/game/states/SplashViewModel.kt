package com.example.x_o.game.states

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel:ViewModel() {

    private val _isLoading= MutableStateFlow(true)

    val  isLoading=_isLoading.asStateFlow()

    // on the initial load
    init {
        viewModelScope.launch {

            // simuladed delay
            delay(1000)
            _isLoading.value=false
        }
    }


}