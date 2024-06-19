package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.StringRes

data class AlkalinityData(
    @StringRes val subtitle: Int,
    @StringRes val subtitle2: Int,
    @StringRes val subtitle3: Int,
    @StringRes val subtitle4: Int,
    @StringRes val formulaText: Int,
    val conversionPPMDKH: Double,
    val conversionPPMMEQ: Double,
    val conversionDKHPPM: Double,
    val conversionDKHMEQ: Double,
    val conversionMEQPPM: Double,
    val conversionMEQDKH: Double,
)