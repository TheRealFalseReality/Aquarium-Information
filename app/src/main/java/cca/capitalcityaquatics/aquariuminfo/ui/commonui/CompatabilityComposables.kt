package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
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
    compatibilityDataList: List<CompatibilityData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(
                minSize = dimensionResource(id = R.dimen.grid_column_medium)
            ),
            userScrollEnabled = true,
//			state = LazyGridState(),
            content = {
                items(compatibilityDataList) { compatibilityData ->
                    FishCompatibilityCard(
                        modifier = Modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_verySmall)),
                        compatibilityData = compatibilityData
                    )
                }
                item {
                    DisclaimerNotice()
                }
            }
        )
    }
}

@Composable
fun FishCompatibilityCard(
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
                CompatibilityInfoList(
                    compatibilityData = compatibilityData,
                    contentColor = contentColor
                )
            }
        )
    }
}

@Composable
fun CompatibilityInfoList(
    compatibilityData: CompatibilityData,
    contentColor: Color
) {
    Column(
        modifier = Modifier
            .padding(start = dimensionResource(id = R.dimen.padding_verySmall))
    ) {
        CompatibilityInfoItem(
            title = R.string.text_compatible,
            description = compatibilityData.compatible,
            contentColor = contentColor
        )
        CompatibilityInfoItem(
            title = R.string.text_caution,
            description = compatibilityData.caution,
            contentColor = contentColor
        )
        CompatibilityInfoItem(
            title = R.string.text_incompatible,
            description = compatibilityData.incompatible,
            contentColor = contentColor
        )
    }
}

@Composable
fun CompatibilityInfoItem(
    title: Int,
    description: Int,
    contentColor: Color
) {
    HeaderText(
        text = title,
        color = contentColor,
        style = MaterialTheme.typography.titleSmall
    )
    VerticalSpacerVerySmall()
    BodyText(
        text = description,
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
fun DisclaimerNotice(modifier: Modifier = Modifier) {
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
            DisclaimerNotice()
        }
    }
}