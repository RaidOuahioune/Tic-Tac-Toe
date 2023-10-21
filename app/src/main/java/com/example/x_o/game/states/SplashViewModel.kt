package com.example.x_o.game.states

import androidx.annotation.UiThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.x_o.game.network.HttpClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel:ViewModel() {


    lateinit var data:String
    private val _isLoading= MutableStateFlow(true)

    val  isLoading=_isLoading.asStateFlow()

    // on the initial load
    init {
        viewModelScope.launch {
            _isLoading.value=false
        }
    }

}