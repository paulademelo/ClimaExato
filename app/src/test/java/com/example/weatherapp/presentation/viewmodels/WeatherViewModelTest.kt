package com.example.weatherapp.presentation.viewmodels

import com.example.weatherapp.data.api.WeatherResponse
import com.example.weatherapp.ui.state.WeatherUiState
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class WeatherViewModelTest {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var weatherRepository: WeatherRepository
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        weatherRepository = mock()
        viewModel = WeatherViewModel(weatherRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun whenFetchCityIsSuccessful(): Unit {
        // Dado que o repositório retorna um resultado de sucesso
        val cityName = "São Paulo"
        val weatherData: WeatherResponse = mock()
        whenever(weatherRepository.getWeatherForLocation(cityName)).thenReturn(
            Result.success(
                weatherData
            )
        )

        // Quando a função fetchWeatherForCity é chamada
        viewModel.fetchWeatherForCity(cityName)

        // Então o uiState deve ser atualizado para Success
        assertEquals(WeatherUiState.Success(weatherData), viewModel.uiState.value)
    }

    @Test
    fun whenFetchCityFails(): Unit {
        // Dado que o repositório retorna um resultado de erro
        val cityName = "Teste de Erro"
        val errorMessage = "Erro ao obter dados"
        whenever(weatherRepository.getWeatherForLocation(cityName)).thenReturn(
            Result.failure(
                Exception(errorMessage)
            )
        )

        // Quando a função fetchWeatherForCity é chamada
        viewModel.fetchWeatherForCity(cityName)

        // Então o uiState deve ser atualizado para Error
        assertEquals(
            WeatherUiState.Error("Erro ao obter dados: $errorMessage"),
            viewModel.uiState.value
        )
    }
}