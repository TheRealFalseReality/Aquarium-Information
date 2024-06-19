package cca.capitalcityaquatics.aquariuminfo.tankvolume

import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Cylinder
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolCylCalculatorTest {
    private val view = Cylinder.title
    private val selectedInches = calculatorDataSource.radioTextInches
    private val selectedFeet = calculatorDataSource.radioTextFeet
    private val selectedFull = calculatorDataSource.radioFullCylinder
    private val selectedHalf = calculatorDataSource.radioHalfCylinder
    private val selectedCorner = calculatorDataSource.radioCornerCylinder

    @Test
    fun calculate_24_24_in() {
        val selected = selectedInches
        val selectedCylinder = selectedFull
        val diameter = 24.0
        val height = 24.0

        val expectedGAL = "47"
        val expectedLIT = "177.92"
        val expectedWW = "391.52"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_24_24_in_half() {
        val selected = selectedInches
        val selectedCylinder = selectedHalf
        val diameter = 24.0
        val height = 24.0

        val expectedGAL = "23.5"
        val expectedLIT = "88.96"
        val expectedWW = "195.76"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_24_24_in_corner() {
        val selected = selectedInches
        val selectedCylinder = selectedCorner
        val diameter = 24.0
        val height = 24.0

        val expectedGAL = "11.75"
        val expectedLIT = "44.48"
        val expectedWW = "97.88"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_36_12_in() {
        val selected = selectedInches
        val selectedCylinder = selectedFull
        val diameter = 36.0
        val height = 12.0

        val expectedGAL = "52.88"
        val expectedLIT = "200.16"
        val expectedWW = "440.46"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_72_21_in() {
        val selected = selectedInches
        val selectedCylinder = selectedFull
        val diameter = 72.0
        val height = 12.0

        val expectedGAL = "211.51"
        val expectedLIT = "800.64"
        val expectedWW = "1761.85"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_2_2_ft() {
        val selected = selectedFeet
        val selectedCylinder = selectedFull
        val diameter = 2.0
        val height = 2.0

        val expectedGAL = "47"
        val expectedLIT = "177.92"
        val expectedWW = "391.52"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_3_1_ft() {
        val selected = selectedFeet
        val selectedCylinder = selectedFull
        val diameter = 3.0
        val height = 1.0

        val expectedGAL = "52.88"
        val expectedLIT = "200.16"
        val expectedWW = "440.46"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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
    fun calculate_5_2_ft() {
        val selected = selectedFeet
        val selectedCylinder = selectedFull
        val diameter = 5.0
        val height = 2.0

        val expectedGAL = "293.76"
        val expectedLIT = "1112"
        val expectedWW = "2447.02"
        val dimensions = TankVolumeMethods(
            selected = selected,
            selectedCylinder = selectedCylinder,
            view = view,
            diameter = diameter,
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