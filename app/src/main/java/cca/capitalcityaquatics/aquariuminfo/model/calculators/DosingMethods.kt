package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat

class DosingMethods(
	private val treatment: Double = 0.0,
	private val water: Double = 0.0,
	private val aquarium: Double = 0.0,
	private val decimalFormat: DecimalFormat = DecimalFormat("#.##")
		.apply { roundingMode = RoundingMode.HALF_UP }
) {
	@VisibleForTesting
	fun dosing(): String {
		val dose = (treatment / water) * aquarium
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(dose)
	}
}