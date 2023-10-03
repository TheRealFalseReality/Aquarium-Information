package cca.capitalcityaquatics.aquariuminfo.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.homeCompatibilityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.homeHeaderDataSource
import cca.capitalcityaquatics.aquariuminfo.data.reviewAppDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PopOutCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SmallSpacer
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TitleWideContent
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun HomePage() {
	PageView(
		verticalArrangement = Arrangement.SpaceBetween
	) {
		HomeLayout()
	}
}

@Composable
fun HomeLayout(
) {
	val uriHandler = LocalUriHandler.current
	val appURL = stringResource(id = R.string.url_app)

	TitleWideContent(
		text = Home.title,
		icon = Home.icon
	) {
		SingleWideCard(
			containerColor = MaterialTheme.colorScheme
				.surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_medium)),
		) {
			BodyText(text = homeHeaderDataSource.title) // TODO
			SmallSpacer()
			BodyText(
				text = homeHeaderDataSource.text,
				textAlign = TextAlign.Justify,
			)
		}
	}
	SmallSpacer()
	PopOutCard(
		modifier = Modifier
			.clickable { uriHandler.openUri(appURL) },
		icon = reviewAppDataSource.icon,
		title = reviewAppDataSource.title,
		body = reviewAppDataSource.text,
		containerColor = MaterialTheme.colorScheme.primaryContainer,
		contentColor = MaterialTheme.colorScheme.onPrimaryContainer
	)
	SmallSpacer()
	PopOutCard(
		icon = homeCompatibilityDataSource.icon,
		title = homeCompatibilityDataSource.title,
		body = homeCompatibilityDataSource.text
	)
	SmallSpacer()
//	ThemeSwitch()
//	PopOutlinedCard(
//		text = homeNavigateDataSource.text
//	)
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			HomePage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HomePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			HomePage()
		}
	}
}