package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AlkCalculatorTest {
    private val selectedDKH = calculatorDataSource.radioTextDkh
    private val selectedPPM = calculatorDataSource.radioTextPpm
    private val selectedMEQ = calculatorDataSource.radioTextMeq

    @Test
    fun calculate_14_dkh() {
        val selected = selectedDKH
        val alkalinity = 14.0

        val expectedPPM = "250"
        val expectedMEQ = "5"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_10_dkh() {
        val selected = selectedDKH
        val alkalinity = 10.0

        val expectedPPM = "178.57"
        val expectedMEQ = "3.57"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_28_dkh() {
        val selected = selectedDKH
        val alkalinity = 2.8

        val expectedPPM = "50"
        val expectedMEQ = "1"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_50_ppm() {
        val selected = selectedPPM
        val alkalinity = 50.0

        val expectedDKH = "2.8"
        val expectedMEQ = "1"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualDKH = parameters.calculateAlkalinityDKH()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_1_meq() {
        val selected = selectedMEQ
        val alkalinity = 1.0

        val expectedPPM = "50"
        val expectedDKH = "2.8"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualDKH = parameters.calculateAlkalinityDKH()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedDKH, actualDKH)
    }

    @Test
    fun calculate_5_dkh() {
        val selected = selectedDKH
        val alkalinity = 5.0

        val expectedPPM = "89.28"
        val expectedMEQ = "1.78"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_20_dkh() {
        val selected = selectedDKH
        val alkalinity = 20.0

        val expectedPPM = "357.14"
        val expectedMEQ = "7.14"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_250_ppm() {
        val selected = selectedPPM
        val alkalinity = 250.0

        val expectedDKH = "14"
        val expectedMEQ = "5"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualDKH = parameters.calculateAlkalinityDKH()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_100_ppm() {
        val selected = selectedPPM
        val alkalinity = 100.0

        val expectedDKH = "5.6"
        val expectedMEQ = "2"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualDKH = parameters.calculateAlkalinityDKH()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_500_ppm() {
        val selected = selectedPPM
        val alkalinity = 500.0

        val expectedDKH = "28"
        val expectedMEQ = "10"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualDKH = parameters.calculateAlkalinityDKH()
        val actualMEQ = parameters.calculateAlkalinityMEQ()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }

    @Test
    fun calculate_60_meq() {
        val selected = selectedMEQ
        val alkalinity = 6.0

        val expectedDKH = "16.8"
        val expectedPPM = "300"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualDKH = parameters.calculateAlkalinityDKH()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }

    @Test
    fun calculate_2_meq() {
        val selected = selectedMEQ
        val alkalinity = 2.0

        val expectedDKH = "5.6"
        val expectedPPM = "100"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualDKH = parameters.calculateAlkalinityDKH()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }

    @Test
    fun calculate_8_meq() {
        val selected = selectedMEQ
        val alkalinity = 8.0

        val expectedDKH = "22.4"
        val expectedPPM = "400"
        val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)
        val actualPPM = parameters.calculateAlkalinityPPM()
        val actualDKH = parameters.calculateAlkalinityDKH()

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }
}