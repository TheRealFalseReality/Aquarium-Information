@file:Suppress("unused")

package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Switch
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@Composable
fun FancyIndicator(
	selectedColor: Color,
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
) {
	Box(
		modifier = modifier
			.padding(5.dp)
			.height(3.dp)
			.border(
				BorderStroke(
					50.dp,
					selectedColor
				), shape
			)
	)
}

@Composable
fun FancyAnimatedIndicator(
	modifier: Modifier = Modifier,
	tabPositions: List<TabPosition>,
	selectedTabIndex: Int,
	indicatorColor: Color
) {
	val transition = updateTransition(selectedTabIndex, label = "UpdateTransition")
	val indicatorStart by transition.animateDp(
		transitionSpec = {
			// Handle directionality here, if we are moving to the right, we
			// want the right side of the indicator to move faster, if we are
			// moving to the left, we want the left side to move faster.
			if (initialState < targetState) {
				spring(dampingRatio = 1f, stiffness = 50f)
			} else {
				spring(dampingRatio = 1f, stiffness = 1000f)
			}
		}, label = "IndicatorStart"
	) {
		tabPositions[it].left
	}

	val indicatorEnd by transition.animateDp(
		transitionSpec = {
			// Handle directionality here, if we are moving to the right, we
			// want the right side of the indicator to move faster, if we are
			// moving to the left, we want the left side to move faster.
			if (initialState < targetState) {
				spring(dampingRatio = 1f, stiffness = 1000f)
			} else {
				spring(dampingRatio = 1f, stiffness = 50f)
			}
		}, label = "IndicatorEnd"
	) {
		tabPositions[it].right
	}

	FancyIndicator(
		// Pass the current color to the indicator
		indicatorColor,
		modifier = modifier
			// Fill up the entire TabRow, and place the indicator at the start
			.fillMaxSize()
			.wrapContentSize(align = Alignment.BottomStart)
			// Apply an offset from the start to correctly position the indicator around the tab
			.offset(x = indicatorStart)
			// Make the width of the indicator follow the animated width as we move between tabs
			.width(indicatorEnd - indicatorStart)
	)
}


@Composable
fun AppVersion(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.onSurface,
) {
	val version = cca.capitalcityaquatics.aquariuminfo.BuildConfig.VERSION_NAME
	Row(
		modifier = modifier,
		horizontalArrangement = Arrangement.Center,
	) {
		BodyText(
			text = R.string.app_version,
			color = color
		)
		Text(
			text = stringResource(id = R.string.text_label_version, version),
			style = MaterialTheme.typography.bodyMedium,
			color = color
		)
	}
}

// TODO add !expanded subtitle
@Composable
fun SingleWideCardExpandableRadio(
	modifier: Modifier = Modifier,
	headerModifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	headerStyle: TextStyle = MaterialTheme.typography.titleMedium,
	@StringRes header: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable () -> Unit = {},
	imageContent: @Composable () -> Unit = {},
	descriptionContent: @Composable () -> Unit = {},
	subtitleContent: @Composable () -> Unit = {},
	expandedState: Boolean = false,
	dampingRatio: Float = Spring.DampingRatioLowBouncy,
	stiffness: Float = Spring.StiffnessLow,
	selected: Int,
) {
	var expanded by remember {
		mutableStateOf(expandedState)
	}
	val alpha = animateFloatAsState(if (!expanded) 1f else 0f, label = "")

	Column(modifier = modifier) {
		OutlinedCard(
			shape = shape,
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			border = BorderStroke(
				width = dimensionResource(id = R.dimen.border_stroke_small),
				color = contentColor
			),
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.animateContentSize(
						animationSpec = spring(
							dampingRatio = dampingRatio,
							stiffness = stiffness
						),
					)
			) {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					imageContent()
					Column(
						modifier = Modifier
							.clickable { expanded = !expanded },
					) {
						Row(
							modifier = Modifier
								.fillMaxWidth(),
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.SpaceBetween
						) {
							Column {
								HeaderText(
									modifier = headerModifier,
									text = header,
									color = contentColor,
									style = headerStyle
								)
								subtitleContent()
							}
							if (!expanded) {
								MediumSpacerWidth()
								LabelText(
									modifier = modifier.alpha(alpha.value),
									text = selected,
									maxLines = 2,
									style = MaterialTheme.typography.labelMedium
								)
							}
							IconButton(
								onClick = { expanded = !expanded },
							) {
								Icon(
									painter = if (expanded)
										painterResource(id = R.drawable.ic_expand_less)
									else painterResource(id = R.drawable.ic_expand_more),
									contentDescription = if (expanded) {
										stringResource(R.string.text_show_less)
									} else {
										stringResource(R.string.text_show_more)
									},
								)
							}
						}
						descriptionContent()
					}
					if (expanded) {
						Column(
							modifier = Modifier
								.selectableGroup()
								.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
						) {
							content()
						}
					}
				}
			}
		}
	}
}

@Composable
fun SingleWideCardExpandableFull(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	headerStyle: TextStyle = MaterialTheme.typography.titleMedium,
	@StringRes header: Int? = null,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable () -> Unit = {},
	imageContent: @Composable () -> Unit = {},
	descriptionContent: @Composable () -> Unit = {},
	subtitleContent: @Composable () -> Unit = {},
	expandedState: Boolean = false,
	dampingRatio: Float = Spring.DampingRatioLowBouncy,
	stiffness: Float = Spring.StiffnessLow,
	revealText: Int = R.string.tap_to_reveal
) {
	var expanded by remember {
		mutableStateOf(expandedState)
	}

	Column(modifier = modifier) {
		Card(
			modifier = Modifier
				.clickable { expanded = !expanded },
			shape = shape,
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.animateContentSize(
						animationSpec = spring(
							dampingRatio = dampingRatio,
							stiffness = stiffness
						),
					)
			) {
				Column(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					imageContent()
					Column(
						modifier = Modifier
							.padding(dimensionResource(id = R.dimen.padding_small)),
					) {
						Row(
							modifier = Modifier
								.fillMaxWidth(),
//							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.SpaceBetween
						) {
							if (header != null) {
								Column {
									SmallSpacer()
									HeaderText(
										text = header,
										color = contentColor,
										style = headerStyle
									)
								}
								if (expanded) {
									VerySmallSpacer()
									subtitleContent()
								}
								Row(
									verticalAlignment = Alignment.CenterVertically
								) {
									IconButton(
										onClick = { expanded = !expanded },
									) {
										Icon(
											painter =
											if (expanded)
												painterResource(id = R.drawable.ic_expand_less)
											else painterResource(id = R.drawable.ic_expand_more),
											contentDescription =
											if (expanded) {
												stringResource(R.string.text_show_less)
											} else {
												stringResource(R.string.text_show_more)
											},
										)
									}
								}
							}
						}
					}
					if ( header != null ) {
						if (expanded) {
							Column(
								modifier = Modifier
									.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
							) {
								descriptionContent()
								VerySmallSpacer()
								content()
								SmallSpacer()
							}
						}
					} else {
						Row(
							verticalAlignment = Alignment.CenterVertically
						) {
							BodyText(text = revealText)
							IconButton(
								onClick = { expanded = !expanded },
							) {
								Icon(
									painter =
									if (expanded)
										painterResource(id = R.drawable.ic_expand_less)
									else painterResource(id = R.drawable.ic_expand_more),
									contentDescription =
									if (expanded) {
										stringResource(R.string.text_show_less)
									} else {
										stringResource(R.string.text_show_more)
									},
								)
							}
						}
						if (expanded) {
							Column(
								modifier = Modifier
									.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
							) {
								SingleWideCard(
									contentColor = contentColor,
									containerColor = containerColor,
								) {
									descriptionContent()
									VerySmallSpacer()
									content()
									SmallSpacer()
								}
							}
						}
					}
				}
			}
		}
	}
}

@Composable
fun TankVolumeResultsString(
	modifier: Modifier = Modifier,
	contentColor: Color,
	calculatedValue1: String,
	calculatedValue2: String,
	calculatedValue3: String,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		CalculatedTextString(
			text = calculatorDataSource.calculatedTextGallons,
			calculatedValue = calculatedValue1,
			textColor = contentColor,
		)
		CalculatedTextString(
			text = calculatorDataSource.calculatedTextLiters,
			calculatedValue = calculatedValue2,
			textColor = contentColor,
		)
		VerySmallSpacer()
		BodyText(
			text = calculatorDataSource.labelWaterWeight,
			color = contentColor
		)
		CalculatedTextString(
			text = calculatorDataSource.calculatedTextWaterWeight,
			calculatedValue = calculatedValue3,
			textColor = contentColor,
		)
	}
}

@Composable
fun CalculateImageTitle(
	color: Color = MaterialTheme.colorScheme.onBackground,
	@DrawableRes image: Int,
	@StringRes contentDescription: Int,
) {
	Column(
		modifier = Modifier.fillMaxWidth(),
	) {
		TitleTextIcon(
			text = R.string.dimension_reference,
			icon = R.drawable.ic_view,
			color = color
		)
	}
	VerySmallSpacer()
	CalculateImage(
		painter = image,
		contentDescription = contentDescription,
		colorFilter = color,
	)
}

@Composable
fun FormulaString(
	@StringRes text: Int,
	expandedState: Boolean = true,
	contentColor: Color = MaterialTheme.colorScheme.onSurface,
	containerColor: Color = MaterialTheme.colorScheme
		.surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_medium)),
) {
	TitleWideContent(
		text = R.string.formula,
		icon = R.drawable.ic_function,
		color = contentColor,
	) {
		SingleWideCard(
			contentColor = contentColor,
			containerColor = containerColor,
		) {
			BodyText(
				text = text,
				color = contentColor,
			)
		}
	}
}

@Composable
fun FormulaStringContent(
	modifier: Modifier = Modifier,
	contentColor: Color = MaterialTheme.colorScheme.onSurface,
	containerColor: Color = MaterialTheme.colorScheme
		.surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_medium)),
	content: @Composable () -> Unit,
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = R.string.formula,
			icon = R.drawable.ic_function,
			color = contentColor,
		) {
			SingleWideCard(
				contentColor = contentColor,
				containerColor = containerColor,
			) {
				Column(
					horizontalAlignment = Alignment.Start
				) {
					content()
				}
			}
		}
	}
}

@Composable
fun CalculatorSubtitleTwo(
	contentColor: Color,
	@StringRes text1: Int,
	@StringRes text2: Int,
) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		HeaderText(
			text = text1,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text2,
			color = contentColor
		)
	}
}

@Composable
fun CalculatorSubtitleThree(
	contentColor: Color,
	@StringRes text1: Int,
	@StringRes text2: Int,
	@StringRes text3: Int,
) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		HeaderText(
			text = text1,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text2,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text3,
			color = contentColor
		)
	}
}

@Composable
fun SalinityCalculatedString(
	@StringRes label1: Int,
	@StringRes inputText1: Int,
	value1: String,
	@StringRes label2: Int,
	@StringRes inputText2: Int,
	value2: String,
	@StringRes label3: Int,
	@StringRes inputText3: Int,
	value3: String,
	contentColor: Color
) {
	// Salinity // TODO
	BodyText(
		text = label1,
		color = contentColor
	)
	CalculatedTextString(
		text = inputText1,
		calculatedValue = value1,
		textColor = contentColor,
	)
	VerySmallSpacer()
	// Density
	BodyText(
		text = label2,
		color = contentColor
	)
	CalculatedTextString(
		text = inputText2,
		calculatedValue = value2,
		textColor = contentColor,
	)
	VerySmallSpacer()
	// Conductivity
	BodyText(
		text = label3,
		color = contentColor
	)
	CalculatedTextString(
		text = inputText3,
		calculatedValue = value3,
		textColor = contentColor,
	)
//	VerySmallSpacer()
//	Row(
//		verticalAlignment = Alignment.CenterVertically
//	) {
//		Column(
//			modifier = Modifier
//				.weight(1f),
//			horizontalAlignment = Alignment.CenterHorizontally
//		) {
//			// Density
//			BodyText(
//				text = label2,
//				color = contentColor
//			)
//			CalculatedTextString(
//				text = inputText2,
//				calculatedValue = value2,
//				textColor = contentColor,
//			)
//		}
//		Column(
//			modifier = Modifier
//			.weight(1f),
//			horizontalAlignment = Alignment.CenterHorizontally
//		) {
//			// Conductivity
//			BodyText(
//				text = label3,
//				color = contentColor
//			)
//			CalculatedTextString(
//				text = inputText3,
//				calculatedValue = value3,
//				textColor = contentColor,
//			)
//		}
//	}
}

@Composable
fun CalculatorSubtitleFour(
	contentColor: Color,
	@StringRes text1: Int,
	@StringRes text2: Int,
	@StringRes text3: Int,
	@StringRes text4: Int,
) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		HeaderText(
			text = text1,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text2,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text3,
			color = contentColor
		)
		SmallSpacerWidth()
		Icon(
			modifier = Modifier
				.size(dimensionResource(id = R.dimen.icon_size_extremelySmall)),
			painter = painterResource(id = R.drawable.ic_sync_alt),
			contentDescription = null,
			tint = contentColor
		)
		SmallSpacerWidth()
		HeaderText(
			text = text4,
			color = contentColor
		)
	}
}

@Composable
fun PopOutCard(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	@StringRes title: Int,
	@StringRes body: Int,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer
) {
	Column(modifier = modifier) {
		SingleWideCard(
			containerColor = containerColor,
			contentColor = contentColor
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					modifier = Modifier
						.size(dimensionResource(id = R.dimen.icon_size_small))
						.weight(2f),
					painter = painterResource(id = icon),
					contentDescription = null,
					tint = contentColor
				)
				Column(
					modifier = Modifier
						.weight(11f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					HeaderText(
						text = title,
						color = contentColor
					)
					BodyText(
						text = body,
						style = MaterialTheme.typography.bodyMedium,
						textAlign = TextAlign.Center,
						color = contentColor
					)
				}
			}
		}
	}
}

@Composable
fun PopOutlinedCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.secondary,
	shape: Shape = Shapes.large
) {
	Column(
		modifier = modifier,
	) {
		OutlinedCard(
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor,
			),
			border = BorderStroke(
				width = dimensionResource(id = R.dimen.border_stroke_small),
				color = contentColor
			),
			shape = shape
		) {
			BodyText(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_large)),
				text = text,
				color = contentColor
			)
		}
	}
}

@Composable
fun ThemeSwitch() {
	var isDarkTheme by remember { mutableStateOf(true) }

	AquariumInformationTheme(dynamicColor = isDarkTheme) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					horizontal = 16.dp,
					vertical = 10.dp
				),
			horizontalArrangement = Arrangement.spacedBy(8.dp)
		) {
			Text("☀️")
			Switch(
				checked = isDarkTheme,
				onCheckedChange = {
					isDarkTheme = it
				}
			)
			Text("🌘")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun RadioRowPreview() {
	AquariumInformationTheme {
		RadioButtonTwoUnits(
			onClick1 = { },
			onClick2 = { },
			label1 = calculatorDataSource.radioTextCelsius,
			label2 = calculatorDataSource.radioTextFahrenheit,
			selected = 1,
			selectedColor = MaterialTheme.colorScheme.primary,
			textColor = MaterialTheme.colorScheme.outline
		)
	}
}

@Preview(showBackground = true)
@Composable
fun SingleWideCardExpandablePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		SingleWideCardExpandableRadio(
			header = calculatorDataSource.labelCylinderType,
			selected = R.string.button_label_cel
		)
	}
}

@Preview(showBackground = true)
@Composable
fun InputNumberPreview() {
	AquariumInformationTheme {
		InputNumberField(
			placeholder = R.string.field_label_cel,
			label = R.string.button_label_cel,
			value = "1",
			onValueChange = { },
			focusedColor = MaterialTheme.colorScheme.onPrimaryContainer,
			focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
			unfocusedColor = MaterialTheme.colorScheme.primary,
			leadingIcon = calculatorDataSource.leadingIconTemperature,
		)
	}
}

@Preview(showBackground = true)
@Composable
fun InputNumberPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		InputNumberField(
			placeholder = R.string.field_label_cel,
			label = R.string.button_label_cel,
			value = "1",
			onValueChange = { },
			focusedColor = MaterialTheme.colorScheme.onPrimaryContainer,
			focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
			unfocusedColor = MaterialTheme.colorScheme.primary,
			leadingIcon = calculatorDataSource.leadingIconTemperature,
		)
	}
}

@Preview(showBackground = true)
@Composable
fun AppInfoPreview() {
	AquariumInformationTheme {
		AppVersion()
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCardPreview() {
	AquariumInformationTheme {
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCardPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TitleTextIconPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleTextIcon(
				icon = R.drawable.ic_conversion,
				text = R.string.converters,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TitleTextIconPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleTextIcon(
				icon = R.drawable.ic_conversion,
				text = R.string.converters,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutCardPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			PopOutCard(
				icon = R.drawable.ic_new_releases,
				title = R.string.text_welcome_compatibility_title,
				body = R.string.text_welcome_compatibility_2
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutCardPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			PopOutCard(
				icon = R.drawable.ic_new_releases,
				title = R.string.text_welcome_compatibility_title,
				body = R.string.text_welcome_compatibility_2
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CardTitlePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleWideContent(
				text = R.string.app_name,
				icon = R.drawable.ic_information
			) {
				SingleWideCard {
					BodyText(text = R.string.text_welcome)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CardTitlePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleWideContent(
				text = R.string.app_name,
				icon = R.drawable.ic_information
			) {
				SingleWideCard {
					BodyText(text = R.string.text_welcome)
				}
			}
		}
	}
}