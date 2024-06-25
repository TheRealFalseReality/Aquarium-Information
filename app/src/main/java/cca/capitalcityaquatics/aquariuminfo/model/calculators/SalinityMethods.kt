package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

class SalinityMethods(
	private val selected: Int,
	private val tds: Double = 0.0,
	private val testWaterTemperature: Double = 25.0,
	pureWaterTemperature: Double = 25.0,
	private val decimalFormat: DecimalFormat = DecimalFormat("#.##")
		.apply { roundingMode = RoundingMode.HALF_UP }
) {
	// Constants for density calculations
	private val a =
		8.24493e-1 - 4.0899e-3 * testWaterTemperature + 7.6438e-5 * testWaterTemperature * testWaterTemperature -
				8.2467e-7 * testWaterTemperature * testWaterTemperature * testWaterTemperature + 5.3875e-9 * testWaterTemperature *
				testWaterTemperature * testWaterTemperature * testWaterTemperature
	private val b =
		-5.72466e-3 + 1.0227e-4 * testWaterTemperature - 1.6546e-6 * testWaterTemperature * testWaterTemperature
	private val c = 4.8314e-4

	// Density of pure water at test and reference temperatures
	private val rROo =
		999.842594 + 6.793952e-2 * testWaterTemperature - 9.095290e-3 * testWaterTemperature *
				testWaterTemperature + 1.001685e-4 * testWaterTemperature * testWaterTemperature * testWaterTemperature -
				1.120083e-6 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature +
				6.536332e-9 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature *
				testWaterTemperature
	private val rROoTD =
		999.842594 + 6.793952e-2 * pureWaterTemperature - 9.095290e-3 * pureWaterTemperature *
				pureWaterTemperature + 1.001685e-4 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature -
				1.120083e-6 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature +
				6.536332e-9 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature *
				pureWaterTemperature
	private var rO1 = tds * rROoTD
	private var roTDS = rROo + a * tds + b * sqrt(tds.pow(3)) + c * tds * tds

	// Iterative variables for calculations
	private var i = 0.0
	private var j = 0.0
	private var p = 0.0
	private var s2 = 0.0

	// Constants for conductivity calculations
	private var c0 = 0.6766097
	private var c1 = 0.0200564
	private var c2 = 0.0001104259
	private var c3 = -0.00000069698
	private var c4 = 0.0000000010031
	private var gt =
		c0 +
				c1 * testWaterTemperature +
				c2 * testWaterTemperature.pow(2) +
				c3 * testWaterTemperature.pow(3) +
				c4 * testWaterTemperature.pow(4)
	private val r: Double = tds / 42.914
	private var rp =
		1.0 +
				(2.07e-5 * p - 6.37e-10 * p + 3.989e-15 * p) /
				(1.0 +
						(3.426e-2 * testWaterTemperature +
								4.464e-4 * testWaterTemperature * testWaterTemperature +
								4.215e-1 * r -
								3.107e-3 * testWaterTemperature * r))
	private var rt = r / (gt * rp)
	private var sal: Double = 0.008 -
			0.1692 * sqrt(rt) +
			25.3851 * rt +
			14.0941 * sqrt(rt.pow(3)) -
			7.0261 * rt * rt +
			2.7081 * sqrt(rt.pow(5)) +
			((testWaterTemperature - 15) / (1 + 0.0162 * (testWaterTemperature - 15))) *
			(0.0005 -
					0.0056 * sqrt(rt) -
					0.0066 * rt -
					0.0375 * sqrt(rt.pow(3)) +
					0.0636 * rt * rt -
					0.0144 * sqrt(rt.pow(5)))
	private var roSAL = rROo + a * sal + b * sqrt(sal.pow(3)) + c * sal * sal

	// Convert to Specific Gravity
	@VisibleForTesting
	fun calculateSpecificGravity(): String {
		val calculate =
			when (selected) {
				// Salinity
				calculatorDataSource.radioTextSalinity -> {
					roTDS / rROoTD
				}

				// Specific Gravity
				calculatorDataSource.radioTextSpecificGravity -> {
					2.0
				}

				// Density
				calculatorDataSource.radioTextDensity -> {
					tds / rROoTD
				}

				// Conductivity
				calculatorDataSource.radioTextConductivity -> {
					roSAL / rROoTD
				}

				// error
				else -> {
					0.0
				}
			}

		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP
		return df.format(calculate)
	}

	// Convert to Salinity
	@VisibleForTesting
	fun calculateSalinity(): String {
		var ro: Double

		val calculate =
			when (selected) {
				// Salinity
				calculatorDataSource.radioTextSalinity -> {
					1.0
				}

				// Specific Gravity
				calculatorDataSource.radioTextSpecificGravity -> {
					do {
						s2 = j / 1000
						ro = rROo + a * s2 + b * sqrt(s2.pow(3)) + c * s2 * s2
						j++
					} while (ro <= rO1)

					val df = DecimalFormat("#.##")
					df.roundingMode = RoundingMode.HALF_UP

					return df.format(s2)
				}

				// Density
				calculatorDataSource.radioTextDensity -> {
					do {
						s2 = j / 1000
						ro = rROo + a * s2 + b * sqrt(s2.pow(3)) + c * s2 * s2
						j++
					} while (ro <= tds)

					val df = DecimalFormat("#.##")
					df.roundingMode = RoundingMode.HALF_UP

					return df.format(s2)
				}

				// Conductivity
				calculatorDataSource.radioTextConductivity -> {
					sal
				}

				// error
				else -> {
					0.0
				}
			}

		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP
		return df.format(calculate)
	}

	// Convert to Density
	@VisibleForTesting
	fun calculateDensity(): String {
		val calculate =
			when (selected) {
				// Salinity
				calculatorDataSource.radioTextSalinity -> {
					rROo + a * tds + b * sqrt(tds.pow(3)) + c * tds * tds
				}

				// Specific Gravity
				calculatorDataSource.radioTextSpecificGravity -> {
					tds * rROoTD
				}

				// Density
				calculatorDataSource.radioTextDensity -> {
					3.0
				}

				// Conductivity
				calculatorDataSource.radioTextConductivity -> {
					roSAL
				}

				// error
				else -> {
					0.0
				}
			}

		return decimalFormat.format(calculate)
	}

	// Convert to Conductivity
	@VisibleForTesting
	fun calculateConductivity(): String {
		var cond: Double
		var r: Double
		var rp: Double
		var rt: Double
		var sal: Double
		var ro: Double

		val calculate =
			when (selected) {
				// Salinity
				calculatorDataSource.radioTextSalinity -> {
					do {
						cond = i / 1000.0
						r = cond / 42.914
						rp =
							1.0 +
									(2.07e-5 * p - 6.37e-10 * p + 3.989e-15 * p) /
									(1.0 +
											(3.426e-2 * testWaterTemperature +
													4.464e-4 * testWaterTemperature * testWaterTemperature +
													4.215e-1 * r -
													3.107e-3 * testWaterTemperature * r))
						rt = r / (gt * rp)
						sal =
							0.008 -
									0.1692 * sqrt(rt) +
									25.3851 * rt +
									14.0941 * sqrt(rt.pow(3)) -
									7.0261 * rt * rt +
									2.7081 * sqrt(rt.pow(5)) +
									((testWaterTemperature - 15) / (1 + 0.0162 * (testWaterTemperature - 15))) *
									(0.0005 -
											0.0056 * sqrt(rt) -
											0.0066 * rt -
											0.0375 * sqrt(rt.pow(3)) +
											0.0636 * rt * rt -
											0.0144 * sqrt(rt.pow(5)))
						i++
					} while (sal <= tds)

					val df = DecimalFormat("#.##")
					df.roundingMode = RoundingMode.HALF_UP

					return df.format(cond)
				}

				// Specific Gravity
				calculatorDataSource.radioTextSpecificGravity -> {
					do {
						s2 = j / 1000.0
						ro = rROo + a * s2 + b * sqrt(s2.pow(3)) + c * s2 * s2
						j++
					} while (ro <= rO1)

					do {
						cond = i / 1000.0
						r = cond / 42.914
						rp =
							1 +
									(2.07e-5 * p - 6.37e-10 * p + 3.989e-15 * p) /
									(1 +
											(3.426e-2 * testWaterTemperature +
													4.464e-4 * testWaterTemperature * testWaterTemperature +
													4.215e-1 * r -
													3.107e-3 * testWaterTemperature * r))
						rt = r / (gt * rp)
						sal =
							0.008 -
									0.1692 * sqrt(rt) +
									25.3851 * rt +
									14.0941 * sqrt(rt.pow(3)) -
									7.0261 * rt * rt +
									2.7081 * sqrt(rt.pow(5)) +
									((testWaterTemperature - 15) / (1 + 0.0162 * (testWaterTemperature - 15))) *
									(0.0005 -
											0.0056 * sqrt(rt) -
											0.0066 * rt -
											0.0375 * sqrt(rt.pow(3)) +
											0.0636 * rt * rt -
											0.0144 * sqrt(rt.pow(5)))
						i++
					} while (sal <= s2)
					val df = DecimalFormat("#.##")
					df.roundingMode = RoundingMode.HALF_UP

					return df.format(cond)
				}

				// Density
				calculatorDataSource.radioTextDensity -> {
					do {
						cond = i / 1000.0
						r = cond / 42.914
						rp =
							1 +
									(2.07e-5 * p - 6.37e-10 * p + 3.989e-15 * p) /
									(1 +
											(3.426e-2 * testWaterTemperature +
													4.464e-4 * testWaterTemperature * testWaterTemperature +
													4.215e-1 * r -
													3.107e-3 * testWaterTemperature * r))
						rt = r / (gt * rp)
						sal =
							0.008 -
									0.1692 * sqrt(rt) +
									25.3851 * rt +
									14.0941 * sqrt(rt.pow(3)) -
									7.0261 * rt * rt +
									2.7081 * sqrt(rt.pow(5)) +
									((testWaterTemperature - 15) / (1 + 0.0162 * (testWaterTemperature - 15))) *
									(0.0005 -
											0.0056 * sqrt(rt) -
											0.0066 * rt -
											0.0375 * sqrt(rt.pow(3)) +
											0.0636 * rt * rt -
											0.0144 * sqrt(rt.pow(5)))
						i++
					} while (sal <= s2)

					return decimalFormat.format(cond)
				}

				// Conductivity
				calculatorDataSource.radioTextConductivity -> {
					4.0
				}

				// error
				else -> {
					0.0
				}
			}

		return decimalFormat.format(calculate)
	}
}