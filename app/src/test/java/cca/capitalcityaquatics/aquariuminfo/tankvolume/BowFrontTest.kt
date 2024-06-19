package cca.capitalcityaquatics.aquariuminfo.tankvolume

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolBFrontCalculatorTest {
    private val view = BowFront.title
    private val selectedInches = calculatorDataSource.radioTextInches
    private val selectedFeet = calculatorDataSource.radioTextFeet

    @Test
    fun calculate_36_12_21_17_in() {
        val selected = selectedInches
        val length = 36.0
        val width = 12.0
        val height = 21.0
        val fullWidth = 17.0

        val expectedGAL = "52.12"
        val expectedLIT = "197.31"
        val expectedWW = "434.2"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_36_12_12_in() {
        val selected = selectedInches
        val length = 36.0
        val width = 12.0
        val height = 12.0
        val fullWidth = 17.0

        val expectedGAL = "29.79"
        val expectedLIT = "112.75"
        val expectedWW = "248.11"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_72_2_21_32_in() {
        val selected = selectedInches
        val length = 72.0
        val width = 24.0
        val height = 21.0
        val fullWidth = 32.0

        val expectedGAL = "198.22"
        val expectedLIT = "750.34"
        val expectedWW = "1651.15"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }

    @Test
    fun calculate_4_2_2_45_ft() {
        val selected = selectedFeet
        val length = 4.0
        val width = 2.0
        val height = 2.0
        val fullWidth = 4.5

        val expectedGAL = "237.19"
        val expectedLIT = "897.87"
        val expectedWW = "1975.81"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
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
        val fullWidth = 1.5

        val expectedGAL = "31.25"
        val expectedLIT = "118.31"
        val expectedWW = "260.35"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
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
        val length = 1.0
        val width = 2.0
        val height = 3.0
        val fullWidth = 2.5

        val expectedGAL = "53.7"
        val expectedLIT = "203.26"
        val expectedWW = "447.29"
        val dimensions = TankVolumeMethods(
            selected = selected,
            view = view,
            length = length,
            width = width,
            height = height,
            fullWidth = fullWidth
        )
        val actualGAL = dimensions.calculateVolumeGallons()
        val actualLIT = dimensions.calculateVolumeLiters()
        val actualWW = dimensions.calculateWaterWeightPounds()

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}