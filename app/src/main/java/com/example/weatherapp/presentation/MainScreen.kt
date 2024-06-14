package com.example.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun MainScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var cityName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("Digite o nome da cidade") },
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { viewModel.fetchWeatherForCity(cityName) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Buscar")
        }

        when (val uiStateValue = uiState) {
            is WeatherViewModel.WeatherUiState.Idle -> {
                // Não exibe nada
            }

            is WeatherViewModel.WeatherUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is WeatherViewModel.WeatherUiState.Error -> {
                val message = uiStateValue.message
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Erro: $message")
                }
            }

            is WeatherViewModel.WeatherUiState.Success -> {
                val weather = uiStateValue.weather
                val backgroundColor = getBackgroundColor(weather.weather.firstOrNull()?.id)

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Temperatura: ${weather.main.temperatureInfo}")
                }
            }
        }
    }
}

fun getBackgroundColor(weatherId: Int?): Color {
    return when (weatherId) {
        in 200..232 -> Color(0x800080FF) // Chuva (Thunderstorm)
        in 300..321 -> Color(0x800080FF) // Chuva (Drizzle)
        in 500..531 -> Color(0x800080FF) // Chuva (Rain)
        in 600..622 -> Color.LightGray // Neve (Snow)
        in 701..781 -> Color.LightGray // Névoa (Mist, Smoke, etc.)
        800 -> Color.Blue // Céu Limpo (Clear)
        in 801..804 -> Color.Gray // Nublado (Clouds)
        else -> Color.White
    }
}