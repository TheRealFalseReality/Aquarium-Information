package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TempConverterTest {
    private val selectedCelsius = calculatorDataSource.radioTextCelsius
    private val selectedFahrenheit = calculatorDataSource.radioTextFahrenheit

    @Test
    fun calculate_32_F() {
        val selected = selectedFahrenheit
        val temperature = 32.0

        val expectedCelsius = "0"
        val expectedKelvin = "273.15"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualCelsius = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedCelsius, actualCelsius)
        assertEquals(expectedKelvin, actualKelvin)
    }

    @Test
    fun calculate_0_F() {
        val selected = selectedFahrenheit
        val temperature = 0.0

        val expectedCelsius = "-17.78"
        val expectedKelvin = "255.37"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualCelsius = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedCelsius, actualCelsius)
        assertEquals(expectedKelvin, actualKelvin)
    }

    @Test
    fun calculate_100_F() {
        val selected = selectedFahrenheit
        val temperature = 100.0

        val expectedCelsius = "37.78"
        val expectedKelvin = "310.93"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualCelsius = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedCelsius, actualCelsius)
        assertEquals(expectedKelvin, actualKelvin)
    }

    @Test
    fun calculate_32_C() {
        val selected = selectedCelsius
        val temperature = 32.0

        val expectedFah = "89.6"
        val expectedKelvin = "305.15"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualFah = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedFah, actualFah)
        assertEquals(expectedKelvin, actualKelvin)
    }

    @Test
    fun calculate_0_C() {
        val selected = selectedCelsius
        val temperature = 0.0

        val expectedFah = "32"
        val expectedKelvin = "273.15"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualFah = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedFah, actualFah)
        assertEquals(expectedKelvin, actualKelvin)
    }

    @Test
    fun calculate_100_C() {
        val selected = selectedCelsius
        val temperature = 100.0

        val expectedFah = "212"
        val expectedKelvin = "373.15"
        val parameters = CalculatorMethods(selected = selected, temperature = temperature)
        val actualFah = parameters.convertTemperature()
        val actualKelvin = parameters.calculateTemperatureKelvin()

        assertEquals(expectedFah, actualFah)
        assertEquals(expectedKelvin, actualKelvin)
    }
}