package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource

@Composable
fun InputNumberField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    @StringRes placeholder: Int = R.string.placeholder_enter,
    value: String,
    onValueChange: (String) -> Unit,
    shape: Shape = RoundedCornerShape(
        bottomStart = 0.dp,
        bottomEnd = 0.dp,
        topStart = dimensionResource(id = R.dimen.shape_medium),
        topEnd = dimensionResource(id = R.dimen.shape_medium),
    ),
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    imeAction: ImeAction = ImeAction.Done,
    @DrawableRes leadingIcon: Int,
) {
    val focusManager = LocalFocusManager.current
    val isError = !value.matches(Regex("[0-9]+(\\.[0-9]+)?"))

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
				.widthIn(max = dimensionResource(id = R.dimen.text_field_width))
				.align(Alignment.CenterHorizontally),
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = focusedColor,
                focusedLabelColor = focusedColor,
                focusedPlaceholderColor = focusedColor,
                focusedTextColor = focusedColor,
                focusedSupportingTextColor = focusedColor,
                cursorColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedTextColor = unfocusedColor,
                unfocusedIndicatorColor = unfocusedColor,
                unfocusedLabelColor = unfocusedColor,
                focusedLeadingIconColor = focusedColor,
                unfocusedLeadingIconColor = unfocusedColor,
                focusedTrailingIconColor = focusedColor,
                unfocusedTrailingIconColor = unfocusedColor
            ),
            label = {
                Text(
                    stringResource(id = label),
                )
            },
            placeholder = {
                Text(
                    stringResource(id = placeholder),
                    maxLines = 1,
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            shape = shape,
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            onValueChange("")
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_trailing_small)),
                            painter = painterResource(id = R.drawable.ic_cancel),
                            contentDescription = stringResource(R.string.clear),
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            },
            leadingIcon = {
                Icon(painter = painterResource(id = leadingIcon), contentDescription = null)
            },
            isError = isError,
            supportingText = {
                if (isError) {
                    BodyText(
                        text = R.string.please_enter_a_number,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
        )
    }
}

@Composable
fun InputNumberFieldTwoInputsStacked(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
) {
    Column(modifier = modifier) {
        InputNumberField(
            label = label1,
            placeholder = placeholder1,
            value = value1,
            onValueChange = onValueChange1,
            focusedColor = focusedColor,
            focusedContainerColor = focusedContainerColor,
            unfocusedColor = unfocusedColor,
            imeAction = ImeAction.Next,
            leadingIcon = leadingIcon1
        )
        VerticalSpacerSmall()
        InputNumberField(
            label = label2,
            placeholder = placeholder2,
            value = value2,
            onValueChange = onValueChange2,
            focusedColor = focusedColor,
            focusedContainerColor = focusedContainerColor,
            unfocusedColor = unfocusedColor,
            leadingIcon = leadingIcon2
        )
    }
}

@Composable
fun InputRowNumberFieldTwoInputs(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label1,
                placeholder = placeholder1,
                value = value1,
                onValueChange = onValueChange1,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon1,
            )
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label2,
                placeholder = placeholder2,
                value = value2,
                onValueChange = onValueChange2,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon = leadingIcon2
            )
        }
    }
}

@Composable
fun InputQuadNumberFieldFourInputs(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    @StringRes label3: Int,
    @StringRes placeholder3: Int = R.string.placeholder_enter,
    @StringRes label4: Int,
    @StringRes placeholder4: Int = R.string.placeholder_enter,
    value3: String,
    onValueChange3: (String) -> Unit,
    value4: String,
    onValueChange4: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
    leadingIcon3: Int,
    leadingIcon4: Int,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label1,
                placeholder = placeholder1,
                value = value1,
                onValueChange = onValueChange1,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon1
            )
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label2,
                placeholder = placeholder2,
                value = value2,
                onValueChange = onValueChange2,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon2
            )
        }
        VerticalSpacerSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label3,
                placeholder = placeholder3,
                value = value3,
                onValueChange = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon3
            )
            InputNumberField(
                modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
                label = label4,
                placeholder = placeholder4,
                value = value4,
                onValueChange = onValueChange4,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon = leadingIcon4
            )
        }
    }
}

@Composable
fun InputNumberFieldThreeInputs(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    @StringRes label3: Int,
    @StringRes placeholder3: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    value3: String,
    onValueChange3: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
    leadingIcon3: Int,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(fraction = 0.95f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label1,
                placeholder = placeholder1,
                value = value1,
                onValueChange = onValueChange1,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon1
            )
            InputNumberField(
                modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label2,
                placeholder = placeholder2,
                value = value2,
                onValueChange = onValueChange2,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon2
            )
            InputNumberField(
                modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label3,
                placeholder = placeholder3,
                value = value3,
                onValueChange = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon = leadingIcon3
            )
        }
    }
}

@Composable
fun InputNumberFieldThreeInputsStacked(
    windowSize: WindowSizeClass,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    @StringRes label3: Int,
    @StringRes placeholder3: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    value3: String,
    onValueChange3: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
    leadingIcon3: Int,
) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            InputNumberFieldThreeInputsStackedLandscape(
                label1 = label1,
                label2 = label2,
                label3 = label3,
                value1 = value1,
                onValueChange1 = onValueChange1,
                value2 = value2,
                onValueChange2 = onValueChange2,
                value3 = value3,
                onValueChange3 = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon1 = leadingIcon1,
                leadingIcon2 = leadingIcon2,
                leadingIcon3 = leadingIcon3,
            )
        }

        else -> {
            InputNumberFieldThreeInputsStackedPortrait(
                label1 = label1,
                label2 = label2,
                label3 = label3,
                value1 = value1,
                onValueChange1 = onValueChange1,
                value2 = value2,
                onValueChange2 = onValueChange2,
                value3 = value3,
                onValueChange3 = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon1 = leadingIcon1,
                leadingIcon2 = leadingIcon2,
                leadingIcon3 = leadingIcon3,
            )
        }
    }

}

@Composable
fun InputNumberFieldThreeInputsStackedPortrait(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    @StringRes label3: Int,
    @StringRes placeholder3: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    value3: String,
    onValueChange3: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
    leadingIcon3: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label1,
                placeholder = placeholder1,
                value = value1,
                onValueChange = onValueChange1,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon1
            )
            InputNumberField(
                modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label2,
                placeholder = placeholder2,
                value = value2,
                onValueChange = onValueChange2,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon2
            )
        }
        VerticalSpacerSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
                label = label3,
                placeholder = placeholder3,
                value = value3,
                onValueChange = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon = leadingIcon3
            )
        }
    }
}

@Composable
fun InputNumberFieldThreeInputsStackedLandscape(
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes placeholder1: Int = R.string.placeholder_enter,
    @StringRes label2: Int,
    @StringRes placeholder2: Int = R.string.placeholder_enter,
    @StringRes label3: Int,
    @StringRes placeholder3: Int = R.string.placeholder_enter,
    value1: String,
    onValueChange1: (String) -> Unit,
    value2: String,
    onValueChange2: (String) -> Unit,
    value3: String,
    onValueChange3: (String) -> Unit,
    focusedColor: Color,
    focusedContainerColor: Color,
    unfocusedColor: Color,
    leadingIcon1: Int,
    leadingIcon2: Int,
    leadingIcon3: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label1,
                placeholder = placeholder1,
                value = value1,
                onValueChange = onValueChange1,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon1
            )
        }
        VerticalSpacerSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
                label = label2,
                placeholder = placeholder2,
                value = value2,
                onValueChange = onValueChange2,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                imeAction = ImeAction.Next,
                leadingIcon = leadingIcon2
            )
        }
        VerticalSpacerSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputNumberField(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
                label = label3,
                placeholder = placeholder3,
                value = value3,
                onValueChange = onValueChange3,
                focusedColor = focusedColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedColor = unfocusedColor,
                leadingIcon = leadingIcon3
            )
        }
    }
}

@Composable
fun CalculateField(
    modifier: Modifier = Modifier,
    @StringRes inputText: Int,
    inputValue: String,
    @StringRes equalsText: Int = calculatorDataSource.approxText,
    calculateContent: @Composable () -> Unit,
    contentColor: Color,
    containerColor: Color,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = inputText, inputValue),
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
            color = contentColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerSmall()
        EqualsText(
            color = contentColor,
            equalsText = equalsText
        )
        VerticalSpacerSmall()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenteredSingleCard(
                contentColor = contentColor,
                containerColor = containerColor
            ) {
                calculateContent()
            }
        }
    }
}

@Composable
fun EqualsText(
    modifier: Modifier = Modifier,
    @StringRes equalsText: Int = calculatorDataSource.approxText,
    color: Color,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = equalsText),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = color,
        )
    }
}


@Composable
fun CalculateFieldTwoInputs(
    modifier: Modifier = Modifier,
    @StringRes inputText: Int,
    inputValue1: String,
    inputValue2: String,
    @StringRes equalsText: Int = calculatorDataSource.approxText,
    calculateContent: @Composable () -> Unit,
    contentColor: Color,
    containerColor: Color,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = inputText, inputValue1, inputValue2),
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
            color = contentColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerSmall()
        EqualsText(
            color = contentColor,
            equalsText = equalsText
        )
        VerticalSpacerSmall()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenteredSingleCard(
                contentColor = contentColor,
                containerColor = containerColor
            ) {
                calculateContent()
            }
        }
    }
}

@Composable
fun CalculateFieldFourInputs(
    modifier: Modifier = Modifier,
    @StringRes inputText: Int,
    inputValue1: String,
    inputValue2: String,
    inputValue3: String,
    inputValue4: String,
    @StringRes equalsText: Int = calculatorDataSource.approxText,
    calculateContent: @Composable () -> Unit,
    contentColor: Color,
    containerColor: Color,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(
                id = inputText,
                inputValue1,
                inputValue2,
                inputValue3,
                inputValue4
            ),
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
            color = contentColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerSmall()
        EqualsText(
            color = contentColor,
            equalsText = equalsText
        )
        VerticalSpacerSmall()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenteredSingleCard(
                contentColor = contentColor,
                containerColor = containerColor
            ) {
                calculateContent()
            }
        }
    }
}

@Composable
fun CalculateFieldThreeInputs(
    modifier: Modifier = Modifier,
    @StringRes inputText: Int,
    inputValue1: String,
    inputValue2: String,
    inputValue3: String,
    @StringRes equalsText: Int = calculatorDataSource.equalsText,
    calculateContent: @Composable () -> Unit,
    contentColor: Color,
    containerColor: Color,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = inputText, inputValue1, inputValue2, inputValue3),
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
            color = contentColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerSmall()
        EqualsText(
            color = contentColor,
            equalsText = equalsText
        )
        VerticalSpacerSmall()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenteredSingleCard(
                contentColor = contentColor,
                containerColor = containerColor
            ) {
                calculateContent()
            }
        }
    }
}

@Composable
fun CalculatedTextString(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    calculatedValue: String,
    textColor: Color,
    maxLines: Int = 1
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = text, calculatedValue),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            maxLines = maxLines
        )
    }
}