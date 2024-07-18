package com.example.weatherapp.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R


@Composable
fun WeatherIconAndTemperature(iconId: Int, cityName: String, temperature: Double) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = stringResource(R.string.icon_weather_description) ,
            modifier = Modifier
                .padding(16.dp)
                .size(150.dp)
        )
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 75.dp)
        )
        Text(
            text = "$temperature°C",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}