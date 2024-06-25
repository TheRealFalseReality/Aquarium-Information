package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.FlowRateMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FlowRateTests {
    @Test
    fun calculate_rate_100() {
        val tankVolume = 100.0

        val expectedLowFreshwater = "300"
        val expectedHighFreshwater = "500"
        val expectedIdealFreshwater = "400"
        val expectedLowMarine = "500"
        val expectedHighMarine = "1000"
        val expectedIdealMarine = "750"
        val parameters = FlowRateMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateMarine = parameters.calculatePumpFlowLowMarine()
        val actualHighRateMarine = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealMarine = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowMarine, actualLowRateMarine)
        assertEquals(expectedHighMarine, actualHighRateMarine)
        assertEquals(expectedIdealMarine, actualHighIdealMarine)
    }

    @Test
    fun calculate_rate_75() {
        val tankVolume = 75.0

        val expectedLowFreshwater = "225"
        val expectedHighFreshwater = "375"
        val expectedIdealFreshwater = "300"
        val expectedLowMarine = "375"
        val expectedHighMarine = "750"
        val expectedIdealMarine = "563"
        val parameters = FlowRateMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateMarine = parameters.calculatePumpFlowLowMarine()
        val actualHighRateMarine = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealMarine = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowMarine, actualLowRateMarine)
        assertEquals(expectedHighMarine, actualHighRateMarine)
        assertEquals(expectedIdealMarine, actualHighIdealMarine)
    }

    @Test
    fun calculate_rate_500() {
        val tankVolume = 500.0

        val expectedLowFreshwater = "1500"
        val expectedHighFreshwater = "2500"
        val expectedIdealFreshwater = "2000"
        val expectedLowMarine = "2500"
        val expectedHighMarine = "5000"
        val expectedIdealMarine = "3750"
        val parameters = FlowRateMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateMarine = parameters.calculatePumpFlowLowMarine()
        val actualHighRateMarine = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealMarine = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowMarine, actualLowRateMarine)
        assertEquals(expectedHighMarine, actualHighRateMarine)
        assertEquals(expectedIdealMarine, actualHighIdealMarine)
    }

    @Test
    fun calculate_rate_60() {
        val tankVolume = 60.0

        val expectedLowFreshwater = "180"
        val expectedHighFreshwater = "300"
        val expectedIdealFreshwater = "240"
        val expectedLowMarine = "300"
        val expectedHighMarine = "600"
        val expectedIdealMarine = "450"
        val parameters = FlowRateMethods(tankVolume = tankVolume)
        val actualLowRateFreshwater = parameters.calculatePumpFlowLowFreshwater()
        val actualHighRateFreshwater = parameters.calculatePumpFlowHighFreshwater()
        val actualIdealRateFreshwater = parameters.calculatePumpFlowIdealFreshwater()
        val actualLowRateMarine = parameters.calculatePumpFlowLowMarine()
        val actualHighRateMarine = parameters.calculatePumpFlowHighMarine()
        val actualHighIdealMarine = parameters.calculatePumpFlowIdealMarine()

        assertEquals(expectedLowFreshwater, actualLowRateFreshwater)
        assertEquals(expectedHighFreshwater, actualHighRateFreshwater)
        assertEquals(expectedIdealFreshwater, actualIdealRateFreshwater)
        assertEquals(expectedLowMarine, actualLowRateMarine)
        assertEquals(expectedHighMarine, actualHighRateMarine)
        assertEquals(expectedIdealMarine, actualHighIdealMarine)
    }
}