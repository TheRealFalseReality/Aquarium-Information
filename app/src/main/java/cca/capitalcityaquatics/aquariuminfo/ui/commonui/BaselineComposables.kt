package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.bowFrontDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@Composable
fun VerticalSpacerMedium(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    }
}

@Composable
fun VerticalSpacerSmall(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
    }
}

@Composable
fun HorizontalSpacerSmall(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
    }
}

@Composable
fun HorizontalSpacerMedium(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
    }
}

@Composable
fun VerticalSpacerVerySmall(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
    }
}

@Composable
fun VerticalSpacerExtremelySmall(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_extremelySmall)))
    }
}

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {
    HorizontalDivider(
        modifier = modifier
            .fillMaxWidth(fraction = 0.8f),
        color = color
    )
}

@Composable
fun TitledContentWithIcon(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleTextIcon(
                text = title,
                icon = icon,
                color = contentColor
            )
        }
        VerticalSpacerSmall()
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}

@Composable
fun CenteredSingleCard(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.large,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.9f),
            shape = shape,
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
        ) {
            Column(
                modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
            }
        }
    }
}

@Composable
fun TextOutlinedCard(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color,
    shape: Shape = Shapes.large
) {
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
            Column(
                modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(fraction = 0.6f),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HeaderText(
                        modifier = Modifier.fillMaxWidth(),
                        text = text,
                        color = contentColor,
                        textAlign = TextAlign.Center // Center text within the card
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderTextLarge(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    textAlign: TextAlign = TextAlign.Start
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = text),
            color = color,
            style = style,
            textAlign = textAlign,
        )
    }
}

@Composable
fun CardImage(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes contentDescription: Int,
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .heightIn(max = dimensionResource(id = R.dimen.card_image_height)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textDecoration: TextDecoration = TextDecoration.None
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = text),
            style = style,
            textAlign = textAlign,
            color = color,
            textDecoration = textDecoration
        )
    }
}

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.outline,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = 1,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = text),
            style = style,
            textAlign = textAlign,
            color = color,
            textDecoration = textDecoration,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun BodyText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal,
    maxLines: Int = Int.MAX_VALUE,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = text),
            style = style,
            textAlign = textAlign,
            color = color,
            textDecoration = textDecoration,
            fontWeight = fontWeight,
            fontStyle = fontStyle,
            maxLines = maxLines
        )
    }
}

@Composable
fun TitleTextIcon(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @DrawableRes icon: Int,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_verySmall),
                        end = dimensionResource(id = R.dimen.padding_small)
                    ),
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = text),
                tint = color
            )
            HeaderTextLarge(
                text = text,
                color = color,
            )
        }
        AppDivider(color = color)
    }
}

@Composable
fun IconTextRow(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconTint: Color = MaterialTheme.colorScheme.onBackground,
    @StringRes text: Int,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = dimensionResource(id = R.dimen.padding_medium_small)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .weight(1f),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconTint
            )
            BodyText(
                modifier = Modifier
                    .weight(5f),
                text = text,
                color = textColor,
                textDecoration = textDecoration,
                fontWeight = fontWeight,
                style = style,
            )
        }
    }
}

@Composable
fun RadioText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    textAlign: TextAlign = TextAlign.Center,
) {
    Column(modifier = modifier) {
        BodyText(
            text = text,
            color = color,
            style = style,
            textAlign = textAlign,
            maxLines = 2,
        )
    }
}

@Composable
fun CalculateImage(
    modifier: Modifier = Modifier,
    @DrawableRes painter: Int,
    @StringRes contentDescription: Int,
    colorFilter: Color
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_verySmall))
    ) {
        Image(
            modifier = Modifier
                .heightIn(
                    min = dimensionResource(id = R.dimen.image_size_large),
                    max = 1500.dp
                ),
            painter = painterResource(id = painter),
            contentDescription = stringResource(id = contentDescription),
            colorFilter = ColorFilter.tint(colorFilter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreview() {
    AquariumInformationTheme {
        val color = MaterialTheme.colorScheme.onBackground
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            CalculateImage(
                painter = bowFrontDataSource.image,
                contentDescription = BowFront.title,
                colorFilter = color,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        val color = MaterialTheme.colorScheme.onBackground
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            CalculateImage(
                painter = bowFrontDataSource.image,
                contentDescription = BowFront.title,
                colorFilter = color,
            )
        }
    }
}