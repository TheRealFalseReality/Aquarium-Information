package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.bowFrontDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldFourInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImageWithTitle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputQuadNumberFieldFourInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResultsString
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun BowFrontPage(windowSize: WindowSizeClass) {
	PageView {
		BowFrontLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun BowFrontLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	val view = BowFront.title
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = bowFrontDataSource
	var inputLength by rememberSaveable {
		mutableStateOf("")
	}
	var inputWidth by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var inputFullWidth by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSourceCommon.radioTextInches)
	}
	val length = inputLength.toDoubleOrNull() ?: 0.0
	val width = inputWidth.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val fullWidth = inputFullWidth.toDoubleOrNull() ?: 0.0
	val dimensions = TankVolumeMethods(
		selected = selected,
		view = view,
		length = length,
		width = width,
		height = height,
		fullWidth = fullWidth,
	)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleTwo(
				contentColor = color,
				text1 = dataSourceCommon.subtitleVolume1,
				text2 = dataSourceCommon.subtitleVolume2,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				header = R.string.select_input_units,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = dataSourceCommon.radioTextInches },
						onClick2 = { selected = dataSourceCommon.radioTextFeet },
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
				selected = selected
			)
		},
		inputFieldContent = {
			InputQuadNumberFieldFourInputs(
				label1 = dataSourceCommon.labelLength,
				label2 = dataSourceCommon.labelWidth,
				value1 = inputLength,
				onValueChange1 = { inputLength = it },
				value2 = inputWidth,
				onValueChange2 = { inputWidth = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				label3 = dataSourceCommon.labelHeight,
				label4 = dataSourceCommon.labelFullWidth,
				value3 = inputHeight,
				onValueChange3 = { inputHeight = it },
				value4 = inputFullWidth,
				onValueChange4 = { inputFullWidth = it },
				leadingIcon1 = dataSourceCommon.leadingIconLength,
				leadingIcon2 = dataSourceCommon.leadingIconWidth,
				leadingIcon3 = dataSourceCommon.leadingIconHeight,
				leadingIcon4 = dataSourceCommon.leadingIconFullWidth,
			)
		},
		calculateFieldContent = {
			CalculateFieldFourInputs(
				inputText =
				when (selected) {
					// Inches
					dataSourceCommon.radioTextInches -> {
						dataSourceSpecific.inputTextInches
					}

					// Feet
					else -> {
						dataSourceSpecific.inputTextFeet
					}
				},
				inputValue1 = inputLength,
				inputValue2 = inputWidth,
				inputValue3 = inputHeight,
				inputValue4 = inputFullWidth,
				equalsText = dataSourceCommon.equalsText,
				calculateContent = {
					TankVolumeResultsString(
						contentColor = contentColor,
						gallons = dimensions.calculateVolumeGallons(),
						liters = dimensions.calculateVolumeLiters(),
						waterWeight = dimensions.calculateWaterWeightPounds()
					)
//					when (selected) {
//						dataSourceCommon.radioTextInches -> {
//							TankVolumeResults(
//								contentColor = contentColor,
//								calculatedValue1 = volGallon,
//								calculatedValue2 = volLiter,
//								calculatedValue3 = waterWeight
//							)
//						}
//
//						else -> {
//							TankVolumeResults(
//								contentColor = contentColor,
//								calculatedValue1 = volGallonFT,
//								calculatedValue2 = volLiterFT,
//								calculatedValue3 = waterWeightFT
//							)
//						}
//					}
				},
				containerColor = containerColor,
				contentColor = color
			)
		},
		additionalContent = {
			CalculateImageWithTitle(
				image = dataSourceSpecific.image,
				contentDescription = view,
				color = color
			)
		}
	) {
		FormulaStringCard(
			formulaText = dataSourceSpecific.formulaText,
			contentColor = color
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun BowFrontPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			BowFrontPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun BowFrontPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			BowFrontPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}