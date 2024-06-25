package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceFreshwater
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceMarine
import cca.capitalcityaquatics.aquariuminfo.model.calculators.FlowRateMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HeaderText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HorizontalSpacerMedium
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HorizontalSpacerSmall
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerticalSpacerLarge
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerticalSpacerSmall
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun FlowRatePage(windowSize: WindowSizeClass) {
    PageView(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FlowRateLayout(windowSize = windowSize)
    }

}

@SuppressLint("VisibleForTests")
@Composable
fun FlowRateLayout(
    windowSize: WindowSizeClass,
    color: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
    val dataSourceCommon = calculatorDataSource
    val dataSourceMarine = flowRateDataSourceMarine
    val dataSourceFreshwater = flowRateDataSourceFreshwater
    var inputVolume by rememberSaveable { mutableStateOf("100") }
    var selected by rememberSaveable { mutableIntStateOf(dataSourceCommon.radioTextGallons) }
    val volume = inputVolume.toDoubleOrNull() ?: 0.0
    val parameters = FlowRateMethods(volume)

    GenericCalculatePage(
        windowSize = windowSize,
        selectContent = {
            SingleWideCardExpandableRadio(
                modifier = Modifier.fillMaxWidth(fraction = 0.75f),
                header = R.string.select_input_units,
                expandedState = true,
                selected = selected,
                contentColor = color,
                content = {
                    RadioButtonTwoUnits(
                        onClick1 = { selected = dataSourceCommon.radioTextGallons },
                        onClick2 = { selected = dataSourceCommon.radioTextLiters },
                        label1 = dataSourceCommon.radioTextGallons,
                        label2 = dataSourceCommon.radioTextLiters,
                        selected = selected,
                        selectedColor = color,
                        textColor = color
                    )
                }
            )
        },
        inputFieldContent = {
            InputNumberField(
                label = dataSourceCommon.labelWaterVolume,
                value = inputVolume,
                onValueChange = { inputVolume = it },
                focusedContainerColor = containerColor,
                focusedColor = contentColor,
                unfocusedColor = color,
                leadingIcon = dataSourceCommon.leadingIconWaterVolume,
            )
        },
        calculateFieldContent = {
            CalculateField(
                inputText =
                when (selected) {
                    // Gallons
                    dataSourceCommon.radioTextGallons -> {
                        dataSourceCommon.inputTextGallons
                    }

                    // Liters
                    else -> {
                        dataSourceCommon.inputTextLiters
                    }
                },
                inputValue = inputVolume,
                calculateContent = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalSpacerSmall()
                        HorizontalSpacerMedium()
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
//                            HeaderText(text = dataSourceFreshwater.header)
                            VerticalSpacerSmall()
                            VerticalSpacerLarge()
                            BodyText(text = dataSourceCommon.flowIdeal)
                            VerticalSpacerSmall()
                            BodyText(text = dataSourceCommon.flowMin)
                            VerticalSpacerSmall()
                            BodyText(text = dataSourceCommon.flowMax)
                        }
                        HorizontalSpacerSmall()
                        // Freshwater
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            HeaderText(text = dataSourceFreshwater.header)
                            VerticalSpacerSmall()
                            when (selected) {
                                // Gallons
                                dataSourceCommon.radioTextGallons -> {
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowIdealFreshwater(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowLowFreshwater(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowHighFreshwater(),
                                        textColor = contentColor,
                                    )
                                }

                                // Liters
                                else -> {
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowIdealFreshwater(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowLowFreshwater(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowHighFreshwater(),
                                        textColor = contentColor,
                                    )
                                }
                            }
                        }
                        HorizontalSpacerSmall()
                        // Marine
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            HeaderText(text = dataSourceMarine.header)
                            VerticalSpacerSmall()
                            when (selected) {
                                // Gallons
                                dataSourceCommon.radioTextGallons -> {
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowIdealMarine(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowLowMarine(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextGallonsHour,
                                        calculatedValue = parameters.calculatePumpFlowHighMarine(),
                                        textColor = contentColor,
                                    )
                                }

                                // Liters
                                else -> {
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowIdealMarine(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowLowMarine(),
                                        textColor = contentColor,
                                    )
                                    VerticalSpacerSmall()
                                    CalculatedTextString(
                                        text = dataSourceCommon.calculatedTextLitersHour,
                                        calculatedValue = parameters.calculatePumpFlowHighMarine(),
                                        textColor = contentColor,
                                    )
                                }
                            }
                        }
                        HorizontalSpacerSmall()
                    }

                },
                contentColor = color,
                equalsText = dataSourceCommon.equalsTextFlow,
                containerColor = containerColor
            )
        }
    )
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun FlowRatePagePreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            FlowRatePage(
                windowSize = WindowSizeClass.calculateFromSize(
                    DpSize(
                        300.dp,
                        400.dp
                    )
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun FlowRate(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            FlowRatePage(
                windowSize = WindowSizeClass.calculateFromSize(
                    DpSize(
                        300.dp,
                        400.dp
                    )
                )
            )
        }
    }
}