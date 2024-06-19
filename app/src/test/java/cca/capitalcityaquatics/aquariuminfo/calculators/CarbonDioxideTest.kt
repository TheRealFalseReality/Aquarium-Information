package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CO2ConverterTest {
    @Test
    fun calculate_9_dkh_83_ph() {
        val pH = 8.30
        val dKH = 9.00

        val expectedCO2 = "1.36"
        val parameters = CalculatorMethods(pH = pH, dKH = dKH)
        val actualCO2 = parameters.calculateCarbonDioxide()

        assertEquals(expectedCO2, actualCO2)
    }

    @Test
    fun calculate_12_dkh_83_ph() {
        val pH = 8.30
        val dKH = 12.00

        val expectedCO2 = "1.81"
        val parameters = CalculatorMethods(pH = pH, dKH = dKH)
        val actualCO2 = parameters.calculateCarbonDioxide()

        assertEquals(expectedCO2, actualCO2)
    }

    @Test
    fun calculate_9_dkh_7_ph() {
        val pH = 7.00
        val dKH = 9.00

        val expectedCO2 = "27.09"
        val parameters = CalculatorMethods(pH = pH, dKH = dKH)
        val actualCO2 = parameters.calculateCarbonDioxide()

        assertEquals(expectedCO2, actualCO2)
    }

    @Test
    fun calculate_12_dkh_7_ph() {
        val pH = 7.00
        val dKH = 12.00

        val expectedCO2 = "36.12"
        val parameters = CalculatorMethods(pH = pH, dKH = dKH)
        val actualCO2 = parameters.calculateCarbonDioxide()

        assertEquals(expectedCO2, actualCO2)
    }

    @Test
    fun calculate_8_dkh_9_ph() {
        val pH = 9.00
        val dKH = 8.00

        val expectedCO2 = "0.24"
        val parameters = CalculatorMethods(pH = pH, dKH = dKH)
        val actualCO2 = parameters.calculateCarbonDioxide()

        assertEquals(expectedCO2, actualCO2)
    }
}