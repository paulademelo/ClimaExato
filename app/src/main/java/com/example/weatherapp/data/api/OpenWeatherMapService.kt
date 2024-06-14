package com.example.weatherapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import  com.example.weatherapp.data.api.WeatherResponse

interface OpenWeatherMapService {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("lang") language: String = "pt_br"
    ): Response<WeatherResponse>
}