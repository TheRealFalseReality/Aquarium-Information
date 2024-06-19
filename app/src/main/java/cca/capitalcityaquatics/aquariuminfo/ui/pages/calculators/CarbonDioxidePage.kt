package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.carbonDioxideDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HeaderText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputRowNumberFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TextOutlinedCard
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun CarbonDioxidePage(windowSize: WindowSizeClass) {
    PageView {
        CarbonDioxideLayout(windowSize = windowSize)
    }
}

@SuppressLint("VisibleForTests")
@Composable
fun CarbonDioxideLayout(
    windowSize: WindowSizeClass,
    color: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
    val dataSourceCommon = calculatorDataSource
    val dataSourceSpecific = carbonDioxideDataSource
    var inputPH by rememberSaveable {
        mutableStateOf("")
    }
    var inputDKH by rememberSaveable {
        mutableStateOf("")
    }
    val ph = inputPH.toDoubleOrNull() ?: 0.0
    val dkh = inputDKH.toDoubleOrNull() ?: 0.0
    val parameters = CalculatorMethods(pH = ph, dKH = dkh)

    GenericCalculatePage(
        windowSize = windowSize,
        subtitleContent = {
            HeaderText(
                text = dataSourceSpecific.subtitle,
                color = color
            )
        },
        selectContent = {
            TextOutlinedCard(
                text = dataSourceSpecific.unitsLabel,
                contentColor = color
            )
        },
        inputFieldContent = {
            InputRowNumberFieldTwoInputs(
                label1 = dataSourceCommon.labelPh,
                label2 = dataSourceCommon.labelDkh,
                value1 = inputPH,
                onValueChange1 = { inputPH = it },
                value2 = inputDKH,
                onValueChange2 = { inputDKH = it },
                focusedContainerColor = containerColor,
                focusedColor = contentColor,
                unfocusedColor = color,
                leadingIcon1 = dataSourceCommon.leadingIconPH,
                leadingIcon2 = dataSourceCommon.leadingIconDKH,
            )
        },
        calculateFieldContent = {
            CalculateFieldTwoInputs(
                inputText = dataSourceCommon.inputText,
                inputValue1 = inputPH,
                inputValue2 = inputDKH,
                contentColor = color,
                containerColor = containerColor,
                calculateContent = {
                    CalculatedTextString(
                        text = dataSourceCommon.calculatedTextCO2,
                        calculatedValue = parameters.calculateCarbonDioxide(),
                        textColor = contentColor,
                    )
                }
            )
        }
    ) {
        FormulaStringCard(
            contentColor = color,
            formulaText = dataSourceSpecific.formulaText,
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            CarbonDioxidePage(
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
fun CarbonDioxidePreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            CarbonDioxidePage(
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