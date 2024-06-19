package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FlowRateData(
    @DrawableRes val image: Int,
    @StringRes val subtitle: Int,
    @StringRes val formulaText: Int,
    @StringRes val icon: Int,
    @StringRes val header: Int,
    val conversionLow: Double,
    val conversionHigh: Double,
)