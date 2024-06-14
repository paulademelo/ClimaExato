package com.example.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class WeatherCondition(
    @SerializedName("Icon")
    val icon: Int,

    @SerializedName("IconPhrase")
    val iconPhrase: String
)
