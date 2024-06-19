package cca.capitalcityaquatics.aquariuminfo.tankvolume

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolCubeCalculatorTest {
    private val view = Cube.title
    private val selectedInches = calculatorDataSource.radioTextInches
    private val selectedFeet = calculatorDataSource.radioTextFeet

    @Test
    fun calculate_24_in() {
        val selected = selectedInches
        val length = 24.0

        val expectedGAL = "59.84"
        val expectedLIT = "226.54"
        val expectedWW = "498.5"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_48_in() {
        val selected = selectedInches
        val length = 48.0

        val expectedGAL = "478.75"
        val expectedLIT = "1812.28"
        val expectedWW = "3988.01"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_36_in() {
        val selected = selectedInches
        val length = 36.0

        val expectedGAL = "201.97"
        val expectedLIT = "764.56"
        val expectedWW = "1682.44"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_72_in() {
        val selected = selectedInches
        val length = 72.0

        val expectedGAL = "1615.79"
        val expectedLIT = "6116.45"
        val expectedWW = "13459.54"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()
        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_4_ft() {
        val selected = selectedFeet

        val length = 4.0
        val expectedGAL = "478.75"
        val expectedLIT = "1812.28"
        val expectedWW = "3988.01"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_3_ft() {
        val selected = selectedFeet
        val length = 3.0

        val expectedGAL = "201.97"
        val expectedLIT = "764.55"
        val expectedWW = "1682.44"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_9_ft() {
        val selected = selectedFeet
        val length = 9.0

        val expectedGAL = "5453.3"
        val expectedLIT = "20642.95"
        val expectedWW = "45425.98"
        val dimensions = TankVolumeMethods(selected = selected, view = view, length = length)
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}