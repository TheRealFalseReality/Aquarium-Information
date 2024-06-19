package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SalConverterTest {
    private val selectedSalinity = calculatorDataSource.radioTextSalinity
    private val selectedSpecificGravity = calculatorDataSource.radioTextSpecificGravity
    private val selectedDensity = calculatorDataSource.radioTextDensity
    private val selectedConductivity = calculatorDataSource.radioTextConductivity

    @Test
    fun calculate_0_ppt() {
        val selected = selectedSalinity
        val tds = 0.0

        val expectedSG = "1"
        val expectedDensity = "997.05"
        val expectedConductivity = "0"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_36_ppt() {
        val selected = selectedSalinity
        val tds = 36.0

        val expectedSG = "1.027"
        val expectedDensity = "1024.1"
        val expectedConductivity = "54.41"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_40_ppt() {
        val selected = selectedSalinity
        val tds = 40.0

        val expectedSG = "1.03"
        val expectedDensity = "1027.13"
        val expectedConductivity = "59.73"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_15_ppt() {
        val selected = selectedSalinity
        val tds = 15.0

        val expectedSG = "1.011"
        val expectedDensity = "1008.3"
        val expectedConductivity = "24.69"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_1011_SG() {
        val selected = selectedSpecificGravity
        val tds = 1.011

        val expectedPPT = "14.62"
        val expectedDensity = "1008.02"
        val expectedConductivity = "24.12"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_1023_SG() {
        val selected = selectedSpecificGravity
        val tds = 1.023

        val expectedPPT = "30.55"
        val expectedDensity = "1019.98"
        val expectedConductivity = "47"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_103_SG() {
        val selected = selectedSpecificGravity
        val tds = 1.03

        val expectedPPT = "39.78"
        val expectedDensity = "1026.96"
        val expectedConductivity = "59.44"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualDensity = parameters.calculateDensity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedDensity, actualDensity)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_1023_Density() {
        val selected = selectedDensity
        val tds = 1023.0

        val expectedPPT = "34.55"
        val expectedSG = "1.026"
        val expectedConductivity = "52.45"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_1000_Density() {
        val selected = selectedDensity
        val tds = 1000.0

        val expectedPPT = "3.92"
        val expectedSG = "1.003"
        val expectedConductivity = "7.14"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_5000_Density() {
        val selected = selectedDensity
        val tds = 5000.0

        val expectedPPT = "2360.74"
        val expectedSG = "5.015"
        val expectedConductivity = "863.61"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualConductivity = parameters.calculateConductivity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedConductivity, actualConductivity)
    }

    @Test
    fun calculate_53_Conductivity() {
        val selected = selectedConductivity
        val tds = 53.0

        val expectedPPT = "34.95"
        val expectedSG = "1.026"
        val expectedDensity = "1023.31"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
    }

    @Test
    fun calculate_72_Conductivity() {
        val selected = selectedConductivity
        val tds = 72.0

        val expectedPPT = "49.51"
        val expectedSG = "1.037"
        val expectedDensity = "1034.35"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
    }

    @Test
    fun calculate_26_Conductivity() {
        val selected = selectedConductivity
        val tds = 26.0

        val expectedPPT = "15.87"
        val expectedSG = "1.012"
        val expectedDensity = "1008.95"
        val parameters = SalinityMethods(selected = selected, tds = tds)
        val actualPPT = parameters.calculateSalinity()
        val actualSG = parameters.calculateSpecificGravity()
        val actualDensity = parameters.calculateDensity()

        assertEquals(expectedPPT, actualPPT)
        assertEquals(expectedSG, actualSG)
        assertEquals(expectedDensity, actualDensity)
    }
}