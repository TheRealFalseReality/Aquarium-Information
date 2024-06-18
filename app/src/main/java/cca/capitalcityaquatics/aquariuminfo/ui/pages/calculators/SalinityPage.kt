package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

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
import cca.capitalcityaquatics.aquariuminfo.data.calculators.salinityDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleFour
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonFourUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SalinityCalculatedString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun SalinityPage(windowSize: WindowSizeClass) {
	PageView {
		SalinityLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun SalinityLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = salinityDataSource
	var inputSal by rememberSaveable {
		mutableStateOf("1.026")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSourceCommon.radioTextSpecificGravity)
	}
	val tds = inputSal.toDoubleOrNull() ?: 0.0
	val parameters = SalinityMethods(selected = selected, tds = tds)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleFour(
				contentColor = color,
				text1 = dataSourceSpecific.subtitle1,
				text2 = dataSourceSpecific.subtitle2,
				text3 = dataSourceSpecific.subtitle3,
				text4 = dataSourceSpecific.subtitle4,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				header = R.string.select_input_units,
				content = {
					RadioButtonFourUnits(
						onClick2 = { selected = dataSourceCommon.radioTextSalinity },
						onClick1 = { selected = dataSourceCommon.radioTextSpecificGravity },
						selected = selected,
						selectedColor = color,
						textColor = color,
						onClick3 = { selected = dataSourceCommon.radioTextDensity },
						onClick4 = { selected = dataSourceCommon.radioTextConductivity },
					)
				}, contentColor = color,
				selected = selected
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					// Specific Gravity
					dataSourceCommon.radioTextSpecificGravity -> {
						dataSourceCommon.labelSg
					}

					// Density
					dataSourceCommon.radioTextDensity -> {
						dataSourceCommon.labelDensity
					}

					// Conductivity
					dataSourceCommon.radioTextConductivity -> {
						dataSourceCommon.labelConductivity
					}

					// Salinity
					else -> {
						dataSourceCommon.labelPpt
					}
				},
				value = inputSal,
				onValueChange = { inputSal = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon =
				when (selected) {
					// Specific Gravity
					dataSourceCommon.radioTextSpecificGravity -> {
						dataSourceCommon.leadingIconSpecificGravity
					}

					// Density
					dataSourceCommon.radioTextDensity -> {
						dataSourceCommon.leadingIconDensity
					}

					// Conductivity
					dataSourceCommon.radioTextConductivity -> {
						dataSourceCommon.leadingIconConductivity
					}

					// Salinity
					else -> {
						dataSourceCommon.leadingIconSalinity
					}
				},
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputText =
				when (selected) {
					// Specific Gravity
					dataSourceCommon.radioTextSpecificGravity -> {
						dataSourceCommon.inputTextSg
					}

					// Density
					dataSourceCommon.radioTextDensity -> {
						dataSourceCommon.inputTextDensity
					}

					// Conductivity
					dataSourceCommon.radioTextConductivity -> {
						dataSourceCommon.inputTextConductivity
					}

					// Salinity
					else -> {
						dataSourceCommon.inputTextPpt
					}
				},
				inputValue = inputSal,
				calculateContent = {
					when (selected) {
						// Specific Gravity
						dataSourceCommon.radioTextSpecificGravity -> {
							SalinityCalculatedString(
								label1 = dataSourceCommon.labelSalinity,
								inputText1 = dataSourceCommon.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSourceCommon.labelDensity,
								inputText2 = dataSourceCommon.calculatedTextDensity,
								value2 = parameters.calculateDensity(),
								label3 = dataSourceCommon.labelConductivity,
								inputText3 = dataSourceCommon.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
							)
						}

						// Density
						dataSourceCommon.radioTextDensity -> {
							SalinityCalculatedString(
								label1 = dataSourceCommon.labelSalinity,
								inputText1 = dataSourceCommon.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSourceCommon.labelSpecificGravity,
								inputText2 = dataSourceCommon.calculatedTextSg,
								value2 = parameters.calculateSpecificGravity(),
								label3 = dataSourceCommon.labelConductivity,
								inputText3 = dataSourceCommon.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
							)
						}

						// Conductivity
						dataSourceCommon.radioTextConductivity -> {
							SalinityCalculatedString(
								label1 = dataSourceCommon.labelSalinity,
								inputText1 = dataSourceCommon.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSourceCommon.labelSpecificGravity,
								inputText2 = dataSourceCommon.calculatedTextSg,
								value2 = parameters.calculateSpecificGravity(),
								label3 = dataSourceCommon.labelDensity,
								inputText3 = dataSourceCommon.calculatedTextDensity,
								value3 = parameters.calculateDensity(),
								contentColor = contentColor,
							)
						}

						// Salinity
						else -> {
							SalinityCalculatedString(
								label1 = dataSourceCommon.labelSpecificGravity,
								inputText1 = dataSourceCommon.calculatedTextPpt,
								value1 = parameters.calculateSpecificGravity(),
								label2 = dataSourceCommon.labelDensity,
								inputText2 = dataSourceCommon.calculatedTextDensity,
								value2 = parameters.calculateDensity(),
								label3 = dataSourceCommon.labelConductivity,
								inputText3 = dataSourceCommon.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
							)
						}
					}
				},
				contentColor = color,
				containerColor = containerColor
			)
		},
//		additionalContent = {
//			SingleWideCardExpandableFull(
////				expandedState = true,
//				header = R.string.text_title_info,
//				content = {
//					SingleWideCard {
//						BodyText(text = R.string.salinity_information)
//						MediumSpacer()
//						HeaderText(text = R.string.ideal_salinity_ranges)
//						SmallSpacer()
//						BodyText(text = R.string.salinity_ideal)
//					}
//				}
//			)
//		}
	) {
		FormulaStringCard(
//			isExpanded = true,
			formulaText = dataSourceSpecific.formulaText, // TODO
			contentColor = color
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun SalinityPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun SalinityPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}