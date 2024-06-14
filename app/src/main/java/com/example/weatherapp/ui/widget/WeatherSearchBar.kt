package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(cityName: String, onCityNameChange: (String) -> Unit, onSearch: () -> Unit) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = cityName,
        onValueChange = onCityNameChange,
        label = {
            Text(
                "Digite o nome da cidade",
                style = TextStyle(color = Color.LightGray)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFFADD8E6),
            focusedBorderColor = Color(0xFF1E90FF)
        ),
        modifier = Modifier
            .padding(top = 60.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onSearch()
            }
        )
    )
}