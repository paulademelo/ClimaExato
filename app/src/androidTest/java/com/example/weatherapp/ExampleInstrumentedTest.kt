package com.example.weatherapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.weatherapp", appContext.packageName)
    }

    @Test
    fun testWeatherInfoDisplaysCorrectData() {
        composeTestRule.onNodeWithText("Clima Exato").assertIsDisplayed()
        Thread.sleep(5000)
        composeTestRule.onNodeWithText("São Paulo").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Ícone relacionado ao tempo").assertIsDisplayed()
    }
}