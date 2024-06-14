package com.example.weatherapp.data.api

import com.example.weatherapp.data.models.TemperatureInfo
import com.example.weatherapp.data.models.WeatherDescription

data class WeatherResponse(
    val weather: List<WeatherDescription>,
    val main: TemperatureInfo
)