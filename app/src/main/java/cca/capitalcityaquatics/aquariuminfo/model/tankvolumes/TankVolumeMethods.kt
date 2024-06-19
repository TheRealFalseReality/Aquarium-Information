package cca.capitalcityaquatics.aquariuminfo.model.tankvolumes

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import cca.capitalcityaquatics.aquariuminfo.navigation.Cylinder
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import cca.capitalcityaquatics.aquariuminfo.navigation.Rectangle
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.pow

class TankVolumeMethods(
    private val selected: Int,
    selectedCylinder: Int? = null,
    view: Int,
    length: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    diameter: Double = 0.0,
    edge: Double = 0.0,
    fullWidth: Double = 0.0,
) {
    private val decimalFormat = DecimalFormat("#.##")
        .apply { roundingMode = RoundingMode.HALF_UP }
    private val radius = diameter / 2.0

    private var volume =
        when (view) {
            // Cube
            Cube.title -> {
                length.pow(3)
            }

            // Cylinder
            Cylinder.title -> {
                when (selectedCylinder) {
                    // Half
                    calculatorDataSource.radioHalfCylinder -> {
                        (PI * radius.pow(2) * height) / 2
                    }

                    // Corner
                    calculatorDataSource.radioCornerCylinder -> {
                        (PI * radius.pow(2) * height) / 4
                    }

                    // Full
                    calculatorDataSource.radioFullCylinder -> {
                        PI * radius.pow(2) * height
                    }

                    // error
                    else -> {
                        0.0
                    }
                }
            }

            // Hexagonal
            Hexagonal.title -> {
                (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height)
            }

            // Bow-Front
            BowFront.title -> {
                ((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height)
            }

            // Rectangle
            Rectangle.title -> {
                length * width * height
            }

            // error
            else -> {
                0.0
            }
        }

    //Gallons
    @VisibleForTesting
    fun calculateVolumeGallons(): String {
        val conversionFactor =
            when (selected) {
                // Inches
                calculatorDataSource.radioTextInches -> {
                    calculatorDataSource.conversionGallonsInches
                }

                // Feet
                calculatorDataSource.radioTextFeet -> {
                    calculatorDataSource.conversionGallonsFeet
                }

                // error
                else -> {
                    0.0
                }
            }
        val volGallons = volume * conversionFactor

        return decimalFormat.format(volGallons)
    }

    //Liters
    @VisibleForTesting
    fun calculateVolumeLiters(): String {
        val conversionFactor =
            when (selected) {
                // Inches
                calculatorDataSource.radioTextInches -> {
                    calculatorDataSource.conversionLitersInches
                }

                // Feet
                calculatorDataSource.radioTextFeet -> {
                    calculatorDataSource.conversionLitersFeet
                }

                // error
                else -> {
                    0.0
                }
            }
        val volLiters = volume * conversionFactor

        return decimalFormat.format(volLiters)
    }

    // Water Weight
    @VisibleForTesting
    fun calculateWaterWeightPounds(): String {
        val conversionFactor = calculatorDataSource.conversionPoundsGallons
        val conversionFactorVolume =
            when (selected) {
                // Inches
                calculatorDataSource.radioTextInches -> {
                    calculatorDataSource.conversionGallonsInches
                }

                // Feet
                calculatorDataSource.radioTextFeet -> {
                    calculatorDataSource.conversionGallonsFeet
                }

                // error
                else -> {
                    0.0
                }
            }
        val waterWeight = (volume * conversionFactorVolume) * conversionFactor

        return decimalFormat.format(waterWeight)
    }
}