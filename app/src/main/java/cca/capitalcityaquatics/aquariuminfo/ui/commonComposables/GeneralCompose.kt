package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.BuildConfig
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.advert.BannerAd
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.HomeScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.TempScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun GeneralComposeHeader(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
) {
	Text(
		text = stringResource(id = text),
		modifier = modifier
			.fillMaxWidth(),
		textAlign = TextAlign.Center,

		style = MaterialTheme.typography.h4.copy(
			fontWeight = FontWeight.ExtraBold
		)
	)
	Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun GeneralComposeSubHeader(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
) {
	Text(
		text = stringResource(id = text),
		modifier = modifier
			.fillMaxWidth(),
		textAlign = TextAlign.Center,
		style = MaterialTheme.typography.h5.copy(
			fontWeight = FontWeight.Bold
		)
	)
	Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun GeneralComposeBody(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	textAlign: TextAlign,
) {
	Text(
		text = stringResource(id = text),
		modifier = modifier,
		textAlign = textAlign,
		style = MaterialTheme.typography.body1
	)
	Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun GeneralComposeFooter(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	textAlign: TextAlign,
	fontWeight: FontWeight,
	style: TextStyle
) {
	Text(
		text = stringResource(id = text),
		modifier = modifier,
		fontSize = 15.sp,
		fontWeight = fontWeight,
		textAlign = textAlign,
		style = style
	)
}

@Composable
fun FormulaString(
	content: @Composable ColumnScope.() -> Unit,
) {
	InfoCardContent(
		icon = painterResource(id = R.drawable.functions_48px),
		title = R.string.text_formula,
		content = content
	)
	Spacer(modifier = Modifier.height(8.dp))
	BannerAd()
}

@Composable
fun AppInfo(
) {
	val version = BuildConfig.VERSION_NAME

	Row(
		horizontalArrangement = Arrangement.Center,
	) {
		Text(
			text = stringResource(id = R.string.text_label_version, version),
		)
	}
}

@Composable
fun UrlClickFoot(
	@StringRes title: Int,
	@StringRes urlLabel: Int,
	url: String,
) {
	val uriHandler = LocalUriHandler.current

	GeneralComposeFooter(
		modifier = Modifier
			.fillMaxWidth(),
		text = title,
		textAlign = TextAlign.Center,
		style = TextStyle(textDecoration = TextDecoration.None),
		fontWeight = FontWeight.Bold
	)

	GeneralComposeFooter(
		modifier = Modifier
			.fillMaxWidth()
			.clickable {
				uriHandler.openUri(url)
			},
		text = urlLabel,
		textAlign = TextAlign.Center,
		style = TextStyle(textDecoration = TextDecoration.Underline),
		fontWeight = FontWeight.Bold
	)
}

@Composable
fun UrlClickSubHead(
	url: String,
	@StringRes urlLabel: Int,
	modifier: Modifier = Modifier,
) {
	val uriHandler = LocalUriHandler.current

	Text(
		text = stringResource(id = urlLabel),
		modifier = modifier
			.clickable {
				uriHandler.openUri(url)
			}
			.fillMaxWidth(),
		textAlign = TextAlign.Center,
		style = MaterialTheme.typography.h5.copy(
			fontWeight = FontWeight.Bold,
			textDecoration = TextDecoration.Underline
		)
	)
}

@Composable
fun ReviewApp() {
	ContentBorder(
		modifier = Modifier
	) {
		val uriHandler = LocalUriHandler.current

		Column(
			modifier = Modifier
				.clickable {
					uriHandler.openUri("https://play.google.com/store/apps/details?id=cca.capitalcityaquatics.aquariuminfo&hl=en_US&pli=1")
				},
			horizontalAlignment = Alignment.CenterHorizontally
		) {


			UrlClickSubHead(
				url = stringResource(id = R.string.url_app),
				urlLabel = R.string.text_rate_app
			)

			Spacer(modifier = Modifier.height(8.dp))

			GeneralComposeFooter(
				text = R.string.text_kindly_review,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Normal,
				style = TextStyle.Default
			)

			GeneralComposeFooter(
				text = R.string.text_valuable_review,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Normal,
				style = TextStyle.Default
			)
			Spacer(modifier = Modifier.height(8.dp))

			Row {
				repeat(5) {
					Icon(
						painter = painterResource(id = R.drawable.grade_48px),
						contentDescription = null,
						Modifier
							.height(30.dp)
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun SalPreview23() {
	AquariumInfoTheme {
		TempScreen()
	}
}

@Preview(showBackground = true)
@Composable
fun HomePreview6() {
	AquariumInfoTheme {
		HomeScreen()
	}
}