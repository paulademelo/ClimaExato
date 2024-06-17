package com.example.weatherapp.ui.widget

import com.example.weatherapp.R

fun icon(weatherId: Int?): Int {
    return when (weatherId) {
        in 200..531 -> R.drawable.storm
        in 600..781 -> R.drawable.snow
        800 -> R.drawable.sun
        in 801..804 -> R.drawable.cloudy
        else -> R.drawable.sun
    }
}