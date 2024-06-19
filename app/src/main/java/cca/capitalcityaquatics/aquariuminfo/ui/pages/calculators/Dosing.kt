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
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.carbonDioxideDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.DosingMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldThreeInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberFieldThreeInputsStackedPortrait
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun DosingPage(windowSize: WindowSizeClass) {
    PageView {
        DosingLayout(windowSize = windowSize)
    }
}

@SuppressLint("VisibleForTests")
@Composable
fun DosingLayout(
    windowSize: WindowSizeClass,
    color: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
    val dataSourceCommon = calculatorDataSource
    val dataSourceSpecific = carbonDioxideDataSource
    var inputTreatment by rememberSaveable {
        mutableStateOf("5")
    }
    var inputWater by rememberSaveable {
        mutableStateOf("50")
    }
    var inputAquarium by rememberSaveable {
        mutableStateOf("100")
    }
    val treatment = inputTreatment.toDoubleOrNull() ?: 0.0
    val water = inputWater.toDoubleOrNull() ?: 0.0
    val aquarium = inputAquarium.toDoubleOrNull() ?: 0.0
    val parameters = DosingMethods(treatment = treatment, water = water, aquarium = aquarium)

    GenericCalculatePage(
        windowSize = windowSize,
        inputFieldContent = {
            InputNumberFieldThreeInputsStackedPortrait(
//				windowSize = windowSize,
                label1 = R.string.treatment,
                label2 = R.string.water,
                label3 = R.string.aquarium,
                value1 = inputTreatment,
                onValueChange1 = { inputTreatment = it },
                value2 = inputWater,
                onValueChange2 = { inputWater = it },
                value3 = inputAquarium,
                onValueChange3 = { inputAquarium = it },
                focusedContainerColor = containerColor,
                focusedColor = contentColor,
                unfocusedColor = color,
                leadingIcon1 = R.drawable.ic_sanitizer, // TODO
                leadingIcon2 = R.drawable.ic_sanitizer,
                leadingIcon3 = R.drawable.ic_sanitizer,
            )
        },
        calculateFieldContent = {
            CalculateFieldThreeInputs(
                inputText = dataSourceCommon.inputText,
                inputValue1 = inputTreatment,
                inputValue2 = inputWater,
                inputValue3 = inputAquarium,
                calculateContent = {
                    CalculatedTextString(
                        text = dataSourceCommon.calculatedTextCO2,
                        calculatedValue = parameters.dosing(),
                        textColor = contentColor,
                    )
                },
                contentColor = color,
                containerColor = containerColor,
            )
        }
    )

}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun DosingPagePreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            DosingPage(
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
fun DosingPagePreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            DosingPage(
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