package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.DosingMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DosingTest {
    @Test
    fun dosing_5_50_120() {
        val treatment = 5.0
        val water = 50.0
        val aquarium = 120.0

        val expectedDose = "12"
        val parameters = DosingMethods(treatment = treatment, water = water, aquarium = aquarium)
        val actualDose = parameters.dosing()

        assertEquals(expectedDose, actualDose)
    }

    @Test
    fun dosing_125_10_100() {
        val treatment = 1.25
        val water = 10.0
        val aquarium = 100.0

        val expectedDose = "12.5"
        val parameters = DosingMethods(treatment = treatment, water = water, aquarium = aquarium)
        val actualDose = parameters.dosing()

        assertEquals(expectedDose, actualDose)
    }

    @Test
    fun dosing_1_100_120() {
        val treatment = 1.0
        val water = 100.0
        val aquarium = 120.0

        val expectedDose = "1.2"
        val parameters = DosingMethods(treatment = treatment, water = water, aquarium = aquarium)
        val actualDose = parameters.dosing()

        assertEquals(expectedDose, actualDose)
    }
}