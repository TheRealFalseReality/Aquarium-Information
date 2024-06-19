package cca.capitalcityaquatics.aquariuminfo.tankvolume

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolHexCalculatorTest {
    private val view = Hexagonal.title
    private val selectedInches = calculatorDataSource.radioTextInches
    private val selectedFeet = calculatorDataSource.radioTextFeet

    @Test
    fun calculate_12_24_in() {
        val selected = selectedInches
        val edge = 12.0
        val height = 24.0

        val expectedGAL = "38.87"
        val expectedLIT = "147.14"
        val expectedWW = "323.79"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_36_12_in() {
        val selected = selectedInches
        val edge = 36.0
        val height = 12.0

        val expectedGAL = "174.91"
        val expectedLIT = "662.13"
        val expectedWW = "1457.04"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_72_21_in() {
        val selected = selectedInches
        val edge = 72.0
        val height = 12.0

        val expectedGAL = "699.66"
        val expectedLIT = "2648.5"
        val expectedWW = "5828.15"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_1_2_ft() {
        val selected = selectedFeet
        val edge = 1.0
        val height = 2.0

        val expectedGAL = "38.87"
        val expectedLIT = "147.14"
        val expectedWW = "323.79"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_3_1_ft() {
        val selected = selectedFeet
        val edge = 3.0
        val height = 1.0

        val expectedGAL = "174.91"
        val expectedLIT = "662.12"
        val expectedWW = "1457.04"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_5_2_ft() {
        val selected = selectedFeet
        val edge = 5.0
        val height = 2.0

        val expectedGAL = "971.75"
        val expectedLIT = "3678.46"
        val expectedWW = "8094.66"
        val dimensions =
            TankVolumeMethods(selected = selected, view = view, edge = edge, height = height)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}