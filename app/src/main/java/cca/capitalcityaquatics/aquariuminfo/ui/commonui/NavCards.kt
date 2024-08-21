package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.Alkalinity
import cca.capitalcityaquatics.aquariuminfo.navigation.Salinity
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@Composable
fun NavButton(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.large,
    containerColor: Color,
    contentColor: Color,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
//        elevation = ButtonDefaults.buttonElevation(
//            defaultElevation = dimensionResource(id = R.dimen.elevation_medium),
//            pressedElevation = dimensionResource(id = R.dimen.elevation_small)
//        )
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BodyText(
                text = title,
                color = contentColor,
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_small))
                    .size(dimensionResource(id = R.dimen.icon_size_verySmall)),
                tint = contentColor,
            )
        }
    }
}

@Composable
fun NavButtonRowTop(
    modifier: Modifier = Modifier,
    @StringRes title1: Int,
    @DrawableRes icon1: Int,
    @StringRes title2: Int,
    @DrawableRes icon2: Int,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {},
) {
    Row(modifier = modifier.fillMaxWidth(fraction = 0.9f)) {
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    end = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = 0.dp,
                bottomStart = dimensionResource(id = R.dimen.card_large),
                topStart = dimensionResource(id = R.dimen.card_large),
                topEnd = dimensionResource(id = R.dimen.card_large),
            ),
            title = title1,
            icon = icon1,
            onClick = onClick1,
            containerColor = containerColor,
            contentColor = contentColor
        )
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = dimensionResource(id = R.dimen.card_large),
                bottomStart = 0.dp,
                topStart = dimensionResource(id = R.dimen.card_large),
                topEnd = dimensionResource(id = R.dimen.card_large),
            ),
            title = title2,
            icon = icon2,
            onClick = onClick2,
            containerColor = containerColor,
            contentColor = contentColor
        )
    }
    VerticalSpacerMedium()
}

@Composable
fun NavButtonRowMid(
    modifier: Modifier = Modifier,
    @StringRes title1: Int,
    @DrawableRes icon1: Int,
    @StringRes title2: Int,
    @DrawableRes icon2: Int,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {},
) {
    Row(modifier = modifier.fillMaxWidth(fraction = 0.9f)) {
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    end = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = 0.dp,
                bottomStart = dimensionResource(id = R.dimen.card_large),
                topEnd = 0.dp,
                topStart = dimensionResource(id = R.dimen.card_large),
            ),
            title = title1,
            icon = icon1,
            onClick = onClick1,
            containerColor = containerColor,
            contentColor = contentColor
        )
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = dimensionResource(id = R.dimen.card_large),
                bottomStart = 0.dp,
                topEnd = dimensionResource(id = R.dimen.card_large),
                topStart = 0.dp
            ),
            title = title2,
            icon = icon2,
            onClick = onClick2,
            containerColor = containerColor,
            contentColor = contentColor
        )
    }
    VerticalSpacerMedium()
}

@Composable
fun NavButtonRowBottom(
    modifier: Modifier = Modifier,
    @StringRes title1: Int,
    @DrawableRes icon1: Int,
    @StringRes title2: Int,
    @DrawableRes icon2: Int,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {},
) {
    Row(modifier = modifier.fillMaxWidth(fraction = 0.9f)) {
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    end = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = dimensionResource(id = R.dimen.card_large),
                bottomStart = dimensionResource(id = R.dimen.card_large),
                topEnd = 0.dp,
                topStart = dimensionResource(id = R.dimen.card_large),
            ),
            title = title1,
            icon = icon1,
            onClick = onClick1,
            containerColor = containerColor,
            contentColor = contentColor
        )
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                ),
            shape = RoundedCornerShape(
                bottomEnd = dimensionResource(id = R.dimen.card_large),
                bottomStart = dimensionResource(id = R.dimen.card_large),
                topEnd = dimensionResource(id = R.dimen.card_large),
                topStart = 0.dp
            ),
            title = title2,
            icon = icon2,
            onClick = onClick2,
            containerColor = containerColor,
            contentColor = contentColor
        )
    }
    VerticalSpacerMedium()
}


@Composable
fun NavButtonWide(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.large,
    containerColor: Color,
    contentColor: Color,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    NavButton(
        modifier = modifier
            .fillMaxWidth(fraction = 0.9f),
        title = title,
        icon = icon,
        onClick = onClick,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
    )
}


//@Composable
//fun NavRowButton(
//	modifier: Modifier = Modifier,
//	shape: Shape = Shapes.large,
//	containerColor: Color = MaterialTheme.colorScheme.background,
//	contentColor: Color = MaterialTheme.colorScheme.onBackground,
//	@StringRes title: Int,
//	@DrawableRes icon: Int,
//	onClick: () -> Unit
//) {
//	Row(
//		modifier = modifier
//	) {
//		Button(
//			modifier = Modifier
//				.fillMaxWidth(fraction = 0.9f)
//				.padding(
//					top = dimensionResource(id = R.dimen.padding_small),
//					bottom = dimensionResource(id = R.dimen.padding_small),
//					end = dimensionResource(id = R.dimen.padding_small),
//				),
//			onClick = onClick,
//			shape = shape,
//			colors = ButtonDefaults.buttonColors(
//				containerColor = containerColor,
//				contentColor = contentColor,
//			),
//			elevation = ButtonDefaults.buttonElevation(
//				defaultElevation = dimensionResource(id = R.dimen.elevation_large),
//				pressedElevation = dimensionResource(id = R.dimen.elevation_small)
//			)
//		) {
//			Row(
//				modifier = Modifier
//					.padding(dimensionResource(id = R.dimen.padding_small))
//					.height(dimensionResource(id = R.dimen.button_height_medium)),
//				verticalAlignment = Alignment.CenterVertically
//			) {
//				Icon(
//					modifier = Modifier
//						.padding(end = dimensionResource(id = R.dimen.padding_small)),
//					painter = painterResource(id = icon),
//					contentDescription = null
//				)
//				Text(
//					text = stringResource(id = title)
//				)
//			}
//		}
//	}
//}

@Composable
fun NavButtonRow(
    modifier: Modifier = Modifier,
    @StringRes title1: Int,
    @DrawableRes icon1: Int,
    @StringRes title2: Int,
    @DrawableRes icon2: Int,
    containerColor: Color,
    contentColor: Color,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(fraction = 0.9f)
    ) {
        NavButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    end = dimensionResource(id = R.dimen.padding_small),
                ),
            title = title1,
            icon = icon1,
            containerColor = containerColor,
            contentColor = contentColor,
            onClick = onClick1
        )
        NavButton(
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                ),
            title = title2,
            icon = icon2,
            containerColor = containerColor,
            contentColor = contentColor,
            onClick = onClick2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavRowStyledPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButtonRowTop(
                title1 = Salinity.title,
                icon1 = Salinity.icon,
                title2 = Alkalinity.title,
                icon2 = Alkalinity.icon,
            )
            NavButtonRowMid(
                title1 = Salinity.title,
                icon1 = Salinity.icon,
                title2 = Alkalinity.title,
                icon2 = Alkalinity.icon,
            )
            NavButtonRowBottom(
                title1 = Salinity.title,
                icon1 = Salinity.icon,
                title2 = Alkalinity.title,
                icon2 = Alkalinity.icon,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavRowButtonPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButtonWide(
                title = R.string.converters,
                icon = R.drawable.ic_home,
                onClick = {},
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavRowButtonPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButtonWide(
                title = R.string.converters,
                icon = R.drawable.ic_home,
                onClick = {},
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavButtonRowPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButtonRow(
                title1 = R.string.converters,
                icon1 = R.drawable.ic_home,
                title2 = R.string.calculators,
                icon2 = R.drawable.ic_email,
                onClick1 = {},
                onClick2 = {},
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavButtonRowPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButtonRow(
                title1 = R.string.converters,
                icon1 = R.drawable.ic_email,
                title2 = R.string.calculators,
                icon2 = R.drawable.ic_email,
                onClick1 = {},
                onClick2 = {},
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavButtonPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButton(
                title = R.string.converters,
                icon = R.drawable.ic_email,
                onClick = {},
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavButtonPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            NavButton(
                title = R.string.converters,
                icon = R.drawable.ic_email,
                onClick = {},
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}