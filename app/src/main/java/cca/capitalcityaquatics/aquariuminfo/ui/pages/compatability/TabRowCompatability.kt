package cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.data.compatability.FreshwaterDataSource
import cca.capitalcityaquatics.aquariuminfo.data.compatability.MarineDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.compatibilityTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CompatibilityDataList
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import kotlinx.coroutines.launch

@Composable
fun CompatibilityTabRow(
    selectedState: Int = 0,
    selectedColor: Color = MaterialTheme.colorScheme.tertiary,
    unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
    val coroutineScope = rememberCoroutineScope()
    val tabs = compatibilityTabRow

    val pagerState = rememberPagerState(
        initialPage = selectedState,
        pageCount = { tabs.size }
    )
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        FancyIndicator(
            Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
            selectedColor,
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = indicator
        ) {
            tabs.forEachIndexed { index, tab ->
                LeadingIconTab(
                    selectedContentColor = selectedColor,
                    unselectedContentColor = unselectedColor,
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = stringResource(id = tab.title),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    icon = {
                        Icon(
                            painter =
                            if (pagerState.currentPage == index) painterResource(id = tab.iconFilled)
                            else painterResource(id = tab.icon),
                            contentDescription = stringResource(id = tab.title)
                        )
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
        ) { index ->
            when (index) {
                0 -> {
                    CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
                }

                1 -> {
                    CompatibilityDataList(MarineDataSource().loadFishCardsMarineDataSource())
                }

                else -> {
                    CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
                }
            }
        }
//		when (state) {
//			0 -> {
//				CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
//			}
//
//			1 -> {
//				CompatibilityDataList(MarineDataSource().loadFishCardsMarineDataSource())
//			}
//		}
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    AquariumInformationTheme {
        CompatibilityTabRow()
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        CompatibilityTabRow()
    }
}