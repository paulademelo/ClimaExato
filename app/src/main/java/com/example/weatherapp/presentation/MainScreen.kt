package com.example.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.R
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.ui.state.WeatherUiState
import com.example.weatherapp.ui.theme.backgroundBrush
import com.example.weatherapp.ui.widget.SearchBar
import com.example.weatherapp.ui.widget.WeatherError
import com.example.weatherapp.ui.widget.WeatherInfo
import kotlinx.coroutines.delay

@Composable
fun MainScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    var splashScreen by remember { mutableStateOf(true) }
    val uiState by viewModel.uiState.collectAsState()
    var cityName by remember { mutableStateOf("São Paulo") }

    LaunchedEffect(key1 = true) {
        viewModel.fetchWeatherForCity(cityName)
        delay(4000)
        splashScreen = false
    }

    if (splashScreen) {
        SplashScreen()
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            when (val uiStateValue = uiState) {
                is WeatherUiState.Success -> {
                    val weather = uiStateValue.weather
                    val backgroundColor = backgroundBrush(weather.weather.firstOrNull()?.id)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                    ) {}
                    WeatherInfo(uiStateValue)
                }

                is WeatherUiState.Error -> {
                    WeatherError(text = stringResource(R.string.error_city_not_founded))
                }

                is WeatherUiState.Loading,
                WeatherUiState.Idle -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
            SearchBar(
                cityName = cityName,
                onCityNameChange = { cityName = it },
                onSearch = { viewModel.fetchWeatherForCity(cityName) },
            )
        }
    }
}