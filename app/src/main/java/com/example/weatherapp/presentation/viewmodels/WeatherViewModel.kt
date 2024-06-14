package com.example.weatherapp.presentation.viewmodels

import android.content.Context
import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.api.WeatherResponse
import com.example.weatherapp.data.repositories.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Idle)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    fun fetchWeatherForCity(cityName: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading
            try {
                val weatherResult = weatherRepository.getWeatherForLocation(cityName)
                _uiState.value = when {
                    weatherResult.isSuccess -> WeatherUiState.Success(weatherResult.getOrThrow())
                    else -> WeatherUiState.Error("Erro ao obter dados: ${weatherResult.exceptionOrNull()?.message ?: "Erro desconhecido"}")
                }
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error("Erro ao carregar dados.")
            }
        }
    }

    fun initializeLocationClient(context: Context) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    }

    sealed class WeatherUiState {
        data object Idle : WeatherUiState()
        data object Loading : WeatherUiState()
        data class Success(val weather: WeatherResponse) : WeatherUiState()
        data class Error(val message: String) : WeatherUiState()
    }
}
