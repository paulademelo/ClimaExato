package com.example.weatherapp.data.repositories

import  com.example.weatherapp.data.api.WeatherResponse
import kotlin.Result

interface WeatherRepository {
    suspend fun getWeatherForLocation(locationName: String): Result<WeatherResponse>
}