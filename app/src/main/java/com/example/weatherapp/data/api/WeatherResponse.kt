package com.example.weatherapp.data.api

import com.example.weatherapp.data.models.Clouds
import com.example.weatherapp.data.models.Coordinates
import com.example.weatherapp.data.models.TemperatureInfo
import com.example.weatherapp.data.models.Sys
import com.example.weatherapp.data.models.WeatherDescription
import com.example.weatherapp.data.models.Wind

/**
 * Data class representing the weather response from the API.
 */
data class WeatherResponse(
    val coord: Coordinates,
    val weather: List<WeatherDescription>,
    val base: String,
    val main: TemperatureInfo,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int
)