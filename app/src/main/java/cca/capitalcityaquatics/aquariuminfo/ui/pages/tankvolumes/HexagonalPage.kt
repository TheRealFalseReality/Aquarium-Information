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
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.hexagonalDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.TankVolumeMethods
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImageWithTitle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputRowNumberFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResultsString
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun HexagonalPage(windowSize: WindowSizeClass) {
	PageView {
		HexagonalLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun HexagonalLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	val view = Hexagonal.title
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = hexagonalDataSource
	var inputEdge by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSourceCommon.radioTextInches)
	}
	val edge = inputEdge.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val dimensions = TankVolumeMethods(
		selected = selected,
		view = view,
		edge = edge,
		height = height
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
			InputRowNumberFieldTwoInputs(
				label1 = dataSourceCommon.labelEdge,
				label2 = dataSourceCommon.labelHeight,
				value1 = inputEdge,
				onValueChange1 = { inputEdge = it },
				value2 = inputHeight,
				onValueChange2 = { inputHeight = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon1 = dataSourceCommon.leadingIconFullWidth,
				leadingIcon2 = dataSourceCommon.leadingIconHeight,
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
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
				inputValue1 = inputEdge,
				inputValue2 = inputHeight,
				equalsText = dataSourceCommon.equalsText,
				calculateContent = {
					TankVolumeResultsString(
						contentColor = contentColor,
						gallons = dimensions.calculateVolumeGallons(),
						liters = dimensions.calculateVolumeLiters(),
						waterWeight = dimensions.calculateWaterWeightPounds()
					)
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
fun HexagonalPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HexagonalPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun HexagonalPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HexagonalPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}