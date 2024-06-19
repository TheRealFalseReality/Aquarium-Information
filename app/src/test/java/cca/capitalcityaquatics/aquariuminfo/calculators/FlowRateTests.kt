package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FlowRateTests {
    @Test
    fun calculate_rate_500() {
        val tankVolume = 500.0

        val expectedLowFreshwater = "1500"
        val expectedHighFreshwater = "2500"
        val expectedIdealFreshwater = "2000"
        val expectedLowReef = "2500"
        val expectedHighReef = "5000"
        val expectedIdealReef = "3750"
        val parameters = CalculatorMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateReef = parameters.calculatePumpFlowLowMarine()
        val actualHighRateReef = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealReef = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowReef, actualLowRateReef)
        assertEquals(expectedHighReef, actualHighRateReef)
        assertEquals(expectedIdealReef, actualHighIdealReef)
    }

    @Test
    fun calculate_rate_60() {
        val tankVolume = 60.0

        val expectedLowFreshwater = "180"
        val expectedHighFreshwater = "300"
        val expectedIdealFreshwater = "240"
        val expectedLowReef = "300"
        val expectedHighReef = "600"
        val expectedIdealReef = "450"
        val parameters = CalculatorMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateReef = parameters.calculatePumpFlowLowMarine()
        val actualHighRateReef = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealReef = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowReef, actualLowRateReef)
        assertEquals(expectedHighReef, actualHighRateReef)
        assertEquals(expectedIdealReef, actualHighIdealReef)
    }
}