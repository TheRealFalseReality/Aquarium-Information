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
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.cubeDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImageWithTitle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResultsString
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun CubePage(windowSize: WindowSizeClass) {
	PageView {
		CubeLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun CubeLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	val view = Cube.title
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = cubeDataSource
	var inputSide by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSourceCommon.radioTextInches)
	}
	val length = inputSide.toDoubleOrNull() ?: 0.0
	val dimensions = TankVolumeMethods(
		selected = selected,
		view = view,
		length = length
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
			InputNumberField(
				label = dataSourceCommon.labelSide,
				value = inputSide,
				onValueChange = { inputSide = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = dataSourceCommon.leadingIconLength,
			)
		},
		calculateFieldContent = {
			CalculateField(
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
				inputValue = inputSide,
				equalsText = dataSourceCommon.equalsText,
				calculateContent = {
					TankVolumeResultsString(
						contentColor = contentColor,
						gallons = dimensions.calculateVolumeGallons(),
						liters = dimensions.calculateVolumeLiters(),
						waterWeight = dimensions.calculateWaterWeightPounds()
					)
				},
				contentColor = color,
				containerColor = containerColor
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
			contentColor = color,
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CubePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CubePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CubePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CubePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}