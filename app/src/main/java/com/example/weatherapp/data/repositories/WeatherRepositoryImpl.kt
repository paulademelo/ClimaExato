package com.example.weatherapp.data.repositories

import javax.inject.Inject
import com.example.weatherapp.data.api.OpenWeatherMapService
import com.example.weatherapp.data.api.WeatherResponse
import kotlin.Result
import com.example.weatherapp.di.OpenWeatherMapApiKey

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherMapService: OpenWeatherMapService,
    @OpenWeatherMapApiKey private val apiKey: String
) : WeatherRepository {

    override suspend fun getWeatherForLocation(locationName: String): Result<WeatherResponse> {
        return try {
            val response = openWeatherMapService.getCurrentWeather(locationName, apiKey)
//            val response = openWeatherMapService.getCurrentWeather(locationName, "acd4e6d9a404739b28111303f4c7a050")
            if (response.isSuccessful) {
                val weatherResponse = response.body()
                if (weatherResponse != null) {
                    Result.success(weatherResponse)
                } else {
                    Result.failure(Exception("Empty response body"))
                }
            } else {
                Result.failure(Exception("Request failed with code ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}