package com.example.weatherapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repositories.WeatherRepository
import com.example.weatherapp.ui.state.WeatherUiState
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

    init {
        viewModelScope.launch {
            fetchWeatherForCity("São Paulo")
        }
    }

    fun fetchWeatherForCity(cityName: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading
            try {
                val weatherResult = weatherRepository.getWeatherForLocation(cityName.trim())
                _uiState.value = when {
                    weatherResult.isSuccess -> WeatherUiState.Success(weatherResult.getOrThrow())
                    else -> WeatherUiState.Error("Erro ao obter dados: ${weatherResult.exceptionOrNull()?.message ?: "Erro desconhecido"}")
                }
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error("Erro ao carregar dados, Tente novamente.")
            }
        }
    }
}