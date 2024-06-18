package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.compatability.CompatibilityData
import cca.capitalcityaquatics.aquariuminfo.data.compatability.disclaimerDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun CompatibilityDataList(
	marineList: List<CompatibilityData>,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		LazyVerticalGrid(
			columns = GridCells.Adaptive(
				minSize = dimensionResource(id = R.dimen.grid_colum_medium)
			),
			userScrollEnabled = true,
			state = LazyGridState(),
			content = {
				items(marineList) { compatibilityData ->
					FishCardsCompatibilityData(
						modifier = Modifier
							.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall)),
						compatibilityData = compatibilityData
					)
				}
				item {
					Column(
						modifier = Modifier.fillMaxSize()
					) {
						Disclaimer()
					}
				}
			}
		)
	}
}

@Composable
fun FishCardsCompatibilityData(
	modifier: Modifier = Modifier,
	compatibilityData: CompatibilityData,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		SingleWideCardExpandableFull(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.95f),
			header = compatibilityData.title,
			headerStyle = MaterialTheme.typography.titleLarge,
			containerColor = containerColor,
			contentColor = contentColor,
			imageContent = {
				// TODO Expand to Full Size?
				CardImage(
					image = compatibilityData.image,
					contentDescription = compatibilityData.title,
				)
			},
			subtitleContent = {
				BodyText(
					text = compatibilityData.latin,
					style = MaterialTheme.typography.labelLarge,
					fontStyle = FontStyle.Italic,
					textAlign = TextAlign.Start,
					color = contentColor
				)
			},
			descriptionContent = {
				BodyText(
					text = compatibilityData.description,
					color = contentColor,
					style = MaterialTheme.typography.bodySmall,
					textAlign = TextAlign.Justify
				)
			},
			content = {
				Column(
					modifier = Modifier
						.padding(start = dimensionResource(id = R.dimen.padding_verySmall))
				) {
					HeaderText(
						text = R.string.text_compatible,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerticalSpacerVerySmall()
					BodyText(
						text = compatibilityData.compatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
					VerticalSpacerSmall()
					HeaderText(
						text = R.string.text_caution,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerticalSpacerVerySmall()
					BodyText(
						text = compatibilityData.caution,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
					VerticalSpacerSmall()
					HeaderText(
						text = R.string.text_incompatible,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerticalSpacerVerySmall()
					BodyText(
						text = compatibilityData.incompatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
				}
			}
		)
	}
}

@Composable
fun BetaFeature(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		BodyText(
			text = R.string.text_beta,
			color = MaterialTheme.colorScheme.error,
			style = MaterialTheme.typography.labelMedium
		)
	}
}

@Composable
fun Disclaimer(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		IconTextRow(
			icon = disclaimerDataSource.icon,
			text = disclaimerDataSource.text,
			fontWeight = FontWeight.Bold
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TankVolumePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			Disclaimer()
		}
	}
}