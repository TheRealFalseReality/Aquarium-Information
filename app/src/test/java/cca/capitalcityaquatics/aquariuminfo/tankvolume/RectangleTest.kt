package cca.capitalcityaquatics.aquariuminfo.tankvolume

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Rectangle
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolRecCalculatorTest {
    private val view = Rectangle.title
    private val selectedInches = calculatorDataSource.radioTextInches
    private val selectedFeet = calculatorDataSource.radioTextFeet

    @Test
    fun calculate_48_24_24_in() {
        val selected = selectedInches
        val length = 48.0
        val width = 24.0
        val height = 24.0

        val expectedGAL = "119.69"
        val expectedLIT = "453.07"
        val expectedWW = "997"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWWPounds = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWWPounds)
    }

    @Test
    fun calculate_36_12_12_in() {
        val selected = selectedInches
        val length = 36.0
        val width = 12.0
        val height = 12.0

        val expectedGAL = "22.44"
        val expectedLIT = "84.95"
        val expectedWW = "186.94"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_72_2_21_in() {
        val selected = selectedInches
        val length = 72.0
        val width = 24.0
        val height = 21.0

        val expectedGAL = "157.09"
        val expectedLIT = "594.66"
        val expectedWW = "1308.57"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_4_2_2_ft() {
        val selected = selectedFeet
        val length = 4.0
        val width = 2.0
        val height = 2.0

        val expectedGAL = "119.69"
        val expectedLIT = "453.07"
        val expectedWW = "997"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_3_1_1_ft() {
        val selected = selectedFeet
        val length = 3.0
        val width = 1.0
        val height = 1.0

        val expectedGAL = "22.44"
        val expectedLIT = "84.95"
        val expectedWW = "186.94"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_3_2_2_ft() {
        val selected = selectedFeet
        val length = 3.0
        val width = 2.0
        val height = 2.0

        val expectedGAL = "89.77"
        val expectedLIT = "339.8"
        val expectedWW = "747.75"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}