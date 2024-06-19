package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.sate.WeatherUiState

@Composable
fun WeatherInfo(uiStateValue: WeatherUiState.Success) {
    val weather = uiStateValue.weather
    val weatherDescription = weather.weather.firstOrNull()?.description.orEmpty()
    val weatherIcon = icon(weather.weather.firstOrNull()?.id)

    Column(
        modifier = Modifier
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherIconAndTemperature(
            iconId = weatherIcon,
            cityName = weather.name,
            temperature = weather.main.temp
        )
        Text(
            text = weatherDescription,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        WeatherDetails(
            windSpeed = weather.wind.speed,
            humidity = weather.main.humidity
        )
    }
}