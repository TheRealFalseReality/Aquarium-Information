package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class CalculatorMethods(
    private val selected: Int? = null,
    private val pH: Double = 0.0,
    private val dKH: Double = 0.0,
    private val alkalinity: Double = 0.0,
    private val temperature: Double = 0.0,
) {
    private val decimalFormat = DecimalFormat("#.##")
        .apply { roundingMode = RoundingMode.HALF_UP }

    // Carbon Dioxide
    @VisibleForTesting
    fun calculateCarbonDioxide(): String {
        val phSolution = 10.0.pow(6.37 - pH)
        val carbonDioxide = (12.839 * dKH) * phSolution

        return decimalFormat.format(carbonDioxide)
    }

    private fun getAlkalinityConversionFactor(
        selected: Int?,
        dkhFactor: Double,
        meqFactor: Double
    ): Double {
        return when (selected) {
            calculatorDataSource.radioTextPpm -> dkhFactor
            calculatorDataSource.radioTextMeq -> meqFactor
            else -> 0.0
        }
    }

    // Alkalinity
    // Convert to dKH
    @VisibleForTesting
    fun calculateAlkalinityDKH(): String {
        val conversionFactor = getAlkalinityConversionFactor(
            selected,
            alkalinityDataSource.conversionDKHPPM,
            alkalinityDataSource.conversionDKHMEQ
        )
//		val conversionFactor =
//			when (selected) {
//				// ppm
//				calculatorDataSource.radioTextPpm -> {
//					alkalinityDataSource.conversionDKHPPM
//				}
//
//				// meq/L
//				calculatorDataSource.radioTextMeq -> {
//					alkalinityDataSource.conversionDKHMEQ
//				}
//
//				// error
//				else -> {
//					0.0
//				}
//			}
        val ppmDKH = alkalinity * conversionFactor

        return decimalFormat.format(ppmDKH)
    }

    // Convert to ppm
    @VisibleForTesting
    fun calculateAlkalinityPPM(): String {
        val conversionFactor =
            when (selected) {
                // dKH
                calculatorDataSource.radioTextDkh -> {
                    alkalinityDataSource.conversionPPMDKH
                }

                // meq/L
                calculatorDataSource.radioTextMeq -> {
                    alkalinityDataSource.conversionPPMMEQ
                }
                // error
                else -> {
                    0.0
                }
            }
        val ppmDKH = alkalinity * conversionFactor

        return decimalFormat.format(ppmDKH)
    }

    // Convert to meq/L
    @VisibleForTesting
    fun calculateAlkalinityMEQ(): String {
        val conversionFactor =
            when (selected) {
                // dKH
                calculatorDataSource.radioTextDkh -> {
                    alkalinityDataSource.conversionMEQDKH
                }

                // ppm
                calculatorDataSource.radioTextPpm -> {
                    alkalinityDataSource.conversionMEQPPM
                }
                // error
                else -> {
                    0.0
                }
            }
        val ppmDKH = alkalinity * conversionFactor

        return decimalFormat.format(ppmDKH)
    }

    // Temperature
    @VisibleForTesting
    fun convertTemperature(): String {
        val calculatedTemperature =
            when (selected) {
                // Fahrenheit
                calculatorDataSource.radioTextFahrenheit -> {
                    (temperature - 32) * (5.0 / 9.0)
                }

                //Celsius
                calculatorDataSource.radioTextCelsius -> {
                    (temperature * (9.0 / 5.0) + 32)
                }
                // error
                else -> {
                    0.0
                }
            }

        return decimalFormat.format(calculatedTemperature)
    }

    // Convert to Kelvin
    @VisibleForTesting
    fun calculateTemperatureKelvin(): String {
        val calculatedTemperature =
            when (selected) {
                // Fahrenheit
                calculatorDataSource.radioTextFahrenheit -> {
                    (temperature - 32) * (5.0 / 9.0)
                }

                //Celsius
                calculatorDataSource.radioTextCelsius -> {
                    temperature
                }
                // error
                else -> {
                    0.0
                }
            }
        val calculatedTemperatureKelvin = calculatedTemperature + 273.15

        return decimalFormat.format(calculatedTemperatureKelvin)
    }
}