package cca.capitalcityaquatics.aquariuminfo.model.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceFreshwater
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceMarine
import com.google.common.annotations.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat

class FlowRateMethods(
    private val tankVolume: Double = 0.0,
    private val decimalFormat: DecimalFormat = DecimalFormat("#")
        .apply { roundingMode = RoundingMode.HALF_UP }
) {

    private fun calculateFlowRate(flowConversion: Double): String {
        val flowRate = tankVolume * flowConversion
        return decimalFormat.format(flowRate)
    }

    @VisibleForTesting
    fun calculatePumpFlowLowMarine(): String =
        calculateFlowRate(flowRateDataSourceMarine.conversionLow)

    @VisibleForTesting
    fun calculatePumpFlowHighMarine(): String =
        calculateFlowRate(flowRateDataSourceMarine.conversionHigh)

    @VisibleForTesting
    fun calculatePumpFlowIdealMarine(): String = calculateFlowRate(
        (flowRateDataSourceMarine.conversionLow + flowRateDataSourceMarine.conversionHigh) / 2.0
    )

    @VisibleForTesting
    fun calculatePumpFlowLowFreshwater(): String =
        calculateFlowRate(flowRateDataSourceFreshwater.conversionLow)

    @VisibleForTesting
    fun calculatePumpFlowHighFreshwater(): String =
        calculateFlowRate(flowRateDataSourceFreshwater.conversionHigh)

    @VisibleForTesting
    fun calculatePumpFlowIdealFreshwater(): String = calculateFlowRate(
        (flowRateDataSourceFreshwater.conversionLow + flowRateDataSourceFreshwater.conversionHigh) / 2.0
    )
}