package com.example.weatherapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun backgroundBrush(weatherId: Int?): Brush {
    return when (weatherId) {
        // Chuva (Thunderstorm)
        in 200..232 -> Brush.verticalGradient(
            colors = listOf(Color(0xFF1A1A1A), Color(0xFF373737))
        )

        // Chuva (Drizzle)
        in 300..321 -> Brush.verticalGradient(
            colors = listOf(Color(0xFF708090), Color(0xFFB0C4DE))
        )

        // Chuva (Rain)
        in 500..531 -> Brush.verticalGradient(
            colors = listOf(Color(0xFF333639), Color(0xFF5F6368))
        )

        // Neve (Snow)
        in 600..622 -> Brush.verticalGradient(
            colors = listOf(Color(0xFFFFFFFF), Color(0xFFBEBEBE))
        )

        // Névoa (Mist, Smoke, etc.)
        in 701..781 -> Brush.verticalGradient(
            colors = listOf(Color(0xFFB0B0B0), Color(0xFFE0E0E0))
        )

        // Céu Limpo (Clear)
        800 -> Brush.verticalGradient(
            colors = listOf(Color(0xFF4682B4), Color(0xFF87CEEB))
        )

        // Nublado (Clouds)
        in 801..804 -> Brush.verticalGradient(
            colors = listOf(Color(0xFF778899), Color(0xFFB0C4DE))
        )

        else -> Brush.verticalGradient(colors = listOf(Color.White, Color.White))
    }
}