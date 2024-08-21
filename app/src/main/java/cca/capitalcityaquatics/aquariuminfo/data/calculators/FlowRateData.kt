package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import cca.capitalcityaquatics.aquariuminfo.R

private const val s = "Tank Size"

data class FlowRateData(
    @DrawableRes val image: Int,
    @StringRes val subtitle: Int,
    @StringRes val title: Int = R.string.flow_rate_subtitle,
    @StringRes val formulaText: Int,
    @DrawableRes val icon: Int,
    @StringRes val header: Int,
    @StringRes val minimum: Int = R.string.flow_rate_minimum,
    @StringRes val label: Int = R.string.flow_rate_label,
    val conversionLow: Double,
    val conversionHigh: Double,
    @StringRes val radioTextGallons: Int = R.string.gallons,
    @StringRes val radioTextLiters: Int = R.string.liters,
    @DrawableRes val iconGallons: Int = R.drawable.freshwater_shark,
)