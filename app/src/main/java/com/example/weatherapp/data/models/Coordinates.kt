package com.example.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon")
    val longitude: Double,

    @SerializedName("lat")
    val latitude: Double
)
