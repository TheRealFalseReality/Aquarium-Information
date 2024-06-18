package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource

@Composable
fun RadioButtonComposable(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	onClick: () -> Unit,
	selected: Boolean,
	selectedColor: Color = MaterialTheme.colorScheme.primary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
	textColor: Color = MaterialTheme.colorScheme.onBackground,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		RadioButton(
			selected = selected,
			onClick = onClick,
			colors = RadioButtonDefaults.colors(
				selectedColor = selectedColor,
				unselectedColor = unselectedColor
			)
		)
		RadioText(
			text = text,
			modifier = Modifier
				.clickable(
					onClick = onClick
				),
			textAlign = TextAlign.Center,
			color = textColor
		)
	}
}

@Composable
fun RadioButtonTwoUnits(
	modifier: Modifier = Modifier,
	onClick1: () -> Unit,
	onClick2: () -> Unit,
	@StringRes label1: Int = calculatorDataSource.radioTextInches,
	@StringRes label2: Int = calculatorDataSource.radioTextFeet,
	selected: Int,
	selectedColor: Color,
	textColor: Color,
) {
	Row(modifier = modifier) {
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label1,
			onClick = onClick1,
			selected = selected == label1,
			selectedColor = selectedColor,
			textColor =
			if (selected == label1) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label2,
			onClick = onClick2,
			selected = selected == label2,
			selectedColor = selectedColor,
			textColor =
			if (selected == label2) textColor
			else MaterialTheme.colorScheme.onBackground
		)
	}
}

@Composable
fun RadioButtonFourUnits(
	modifier: Modifier = Modifier,
	onClick1: () -> Unit,
	onClick2: () -> Unit,
	onClick3: () -> Unit,
	onClick4: () -> Unit,
	@StringRes label1: Int = calculatorDataSource.radioTextSpecificGravity,
	@StringRes label2: Int = calculatorDataSource.radioTextSalinity,
	@StringRes label3: Int = calculatorDataSource.radioTextDensity,
	@StringRes label4: Int = calculatorDataSource.radioTextConductivity,
	selected: Int,
	selectedColor: Color,
	textColor: Color,
) {
	Column(modifier = modifier) {
		Row {
			RadioButtonComposable(
				modifier = Modifier
					.weight(1f),
				text = label1,
				onClick = onClick1,
				selected = selected == label1,
				selectedColor = selectedColor,
				textColor =
				if (selected == label1) textColor
				else MaterialTheme.colorScheme.onBackground
			)
			RadioButtonComposable(
				modifier = Modifier
					.weight(1f),
				text = label2,
				onClick = onClick2,
				selected = selected == label2,
				selectedColor = selectedColor,
				textColor =
				if (selected == label2) textColor
				else MaterialTheme.colorScheme.onBackground
			)
		}
		VerticalSpacerMedium()
		Row {
			RadioButtonComposable(
				modifier = Modifier
					.weight(1f),
				text = label3,
				onClick = onClick3,
				selected = selected == label3,
				selectedColor = selectedColor,
				textColor =
				if (selected == label3) textColor
				else MaterialTheme.colorScheme.onBackground
			)
			RadioButtonComposable(
				modifier = Modifier
					.weight(1f),
				text = label4,
				onClick = onClick4,
				selected = selected == label4,
				selectedColor = selectedColor,
				textColor =
				if (selected == label4) textColor
				else MaterialTheme.colorScheme.onBackground
			)
		}
	}
}

@Composable
fun RadioButtonThreeUnits(
	modifier: Modifier = Modifier,
	onClick1: () -> Unit,
	onClick2: () -> Unit,
	onClick3: () -> Unit,
	@StringRes label1: Int = calculatorDataSource.radioTextDkh,
	@StringRes label2: Int = calculatorDataSource.radioTextPpm,
	@StringRes label3: Int = calculatorDataSource.radioTextMeq,
	selected: Int,
	selectedColor: Color,
	textColor: Color,

	) {
	Row(modifier = modifier) {
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label1,
			onClick = onClick1,
			selected = selected == label1,
			selectedColor = selectedColor,
			textColor =
			if (selected == label1) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label2,
			onClick = onClick2,
			selected = selected == label2,
			selectedColor = selectedColor,
			textColor =
			if (selected == label2) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label3,
			onClick = onClick3,
			selected = selected == label3,
			selectedColor = selectedColor,
			textColor =
			if (selected == label3) textColor
			else MaterialTheme.colorScheme.onBackground
		)
	}
}