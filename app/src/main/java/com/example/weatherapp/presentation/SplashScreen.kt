package com.example.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weatherapp.R.raw.sun
import com.example.weatherapp.ui.theme.LinearGradientSunny

@Composable
fun SplashScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId = sun))
    val progress by animateLottieCompositionAsState(composition)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = LinearGradientSunny()
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "Clima Exato",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}