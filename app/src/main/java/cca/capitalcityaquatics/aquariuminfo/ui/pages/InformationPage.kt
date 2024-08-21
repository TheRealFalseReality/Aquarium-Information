package cca.capitalcityaquatics.aquariuminfo.ui.pages

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.appInformationDataSource
import cca.capitalcityaquatics.aquariuminfo.data.contactDataSource
import cca.capitalcityaquatics.aquariuminfo.data.emailDataSource
import cca.capitalcityaquatics.aquariuminfo.data.errorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.informationHeaderDataSource
import cca.capitalcityaquatics.aquariuminfo.data.reviewAppDataSource
import cca.capitalcityaquatics.aquariuminfo.data.shareDataSource
import cca.capitalcityaquatics.aquariuminfo.data.websiteDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Information
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.AppVersion
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CenteredSingleCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.IconTextRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.ThemeSwitch
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TitledContentWithIcon
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerticalSpacerSmall
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerticalSpacerVerySmall
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage() {
    PageView(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InfoLayout()
    }
}

@Composable
fun InfoLayout(
    text: String = stringResource(id = R.string.url_app),
    shareDialogTitle: String = stringResource(R.string.share),
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    containerColor: Color = MaterialTheme.colorScheme
        .surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_medium)),
) {
    val uriHandler = LocalUriHandler.current
    val context = LocalContext.current
    val emailURL = stringResource(id = R.string.url_email)
    val websiteURL = stringResource(id = R.string.url_website)
    val appURL = stringResource(id = R.string.url_app)
    val changelogURL = stringResource(id = R.string.changelog_url)

    TitledContentWithIcon(
        title = Information.title,
        icon = Information.icon
    ) {
        CenteredSingleCard(
            containerColor = containerColor
        ) {
            BodyText(
                text = informationHeaderDataSource.text,
                color = contentColor
            )
        }
    }
    VerticalSpacerSmall()
    TitledContentWithIcon(
        title = errorDataSource.title,
        icon = errorDataSource.icon,
    ) {
        CenteredSingleCard(
            containerColor = containerColor
        ) {
            BodyText(
                modifier = Modifier
                    .clickable { uriHandler.openUri(emailURL) },
                text = errorDataSource.text,
                color = contentColor
            )
        }
    }
    VerticalSpacerSmall()
    TitledContentWithIcon(
        title = contactDataSource.title,
        icon = contactDataSource.icon,
    ) {
        CenteredSingleCard(
            containerColor = containerColor
        ) {
            IconTextRow(
                modifier = Modifier
                    .clickable { uriHandler.openUri(emailURL) },
                icon = emailDataSource.icon,
                text = emailDataSource.title,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                textColor = contentColor,
                iconTint = contentColor
            )
            IconTextRow(
                modifier = Modifier
                    .clickable { uriHandler.openUri(websiteURL) },
                icon = websiteDataSource.icon,
                text = websiteDataSource.title,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                textColor = contentColor,
                iconTint = contentColor
            )
            IconTextRow(
                modifier = Modifier
                    .clickable { uriHandler.openUri(appURL) },
                icon = reviewAppDataSource.icon,
                text = reviewAppDataSource.title,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                textColor = contentColor,
                iconTint = contentColor
            )
            IconTextRow(
                modifier = Modifier
                    .clickable {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
                        context.startActivity(Intent.createChooser(shareIntent, shareDialogTitle))
                    },
                icon = shareDataSource.icon,
                text = shareDataSource.text,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                textColor = contentColor,
                iconTint = contentColor
            )
        }
    }
    VerticalSpacerSmall()
    TitledContentWithIcon(
        title = appInformationDataSource.title,
        icon = appInformationDataSource.icon,
    ) {
        CenteredSingleCard(
            modifier = Modifier
                .clickable { uriHandler.openUri(changelogURL) },
            containerColor = containerColor,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.weight(8f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppVersion()
                    VerticalSpacerVerySmall()
                    // TODO Add more
                    VerticalSpacerVerySmall()
                    BodyText(
                        text = R.string.tap_to_see_changelog,
                    )
                }
                Icon(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(id = R.drawable.ic_open_new),
                    contentDescription = null
                )
            }
        }
    }
    ThemeSwitch()
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            InfoPage()
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            InfoPage()
        }
    }
}