package com.example.weatherapp.ui.state

import com.example.weatherapp.data.api.WeatherResponse

sealed class WeatherUiState {
    data object Idle : WeatherUiState()
    data object Loading : WeatherUiState()
    data class Success(val weather: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}