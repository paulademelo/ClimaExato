package com.example.weatherapp.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel


@Composable
fun WeatherInfo(uiStateValue: WeatherViewModel.WeatherUiState.Success) {
    val weather = uiStateValue.weather
    val weatherDescription = weather.weather.firstOrNull()?.description ?: ""
    val weatherIcon = icon(weather.weather.firstOrNull()?.id)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = weatherIcon),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(150.dp)
        )
        Text(
            text = weather.name, style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily.SansSerif,
            ), textAlign = TextAlign.Start
        )
        Text(
            text = "${weather.main.temp}°C", style = TextStyle(
                color = Color.White,
                fontSize = 70.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        )
        Text(
            text = weatherDescription, style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}