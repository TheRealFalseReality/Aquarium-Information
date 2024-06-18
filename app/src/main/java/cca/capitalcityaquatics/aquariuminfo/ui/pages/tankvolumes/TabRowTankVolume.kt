package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.navigation.tankVolumeTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TankVolumeTabRow(
	windowSize: WindowSizeClass,
	selectedState: Int = 0,
	selectedColor: Color = MaterialTheme.colorScheme.secondary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	val coroutineScope = rememberCoroutineScope()
	val tabs = tankVolumeTabRow
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
		when (windowSize.widthSizeClass) {
			WindowWidthSizeClass.Compact -> {
				ScrollableTabRow(
					selectedTabIndex = pagerState.currentPage,
					indicator = indicator,
				) {
					tabs.forEachIndexed { index, tab ->
						Tab(
							selected = pagerState.currentPage == index,
							onClick = {
								coroutineScope.launch {
									pagerState.animateScrollToPage(index)
								}
							},
							selectedContentColor = selectedColor,
							unselectedContentColor = unselectedColor,
							text = {
								Text(
									text = stringResource(id = tab.title),
									maxLines = 1,
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
			}

			else -> {
				TabRow(
					selectedTabIndex = pagerState.currentPage,
					indicator = indicator,
				) {
					when (windowSize.heightSizeClass) {
						WindowHeightSizeClass.Compact -> {
							tabs.forEachIndexed { index, tab ->
								LeadingIconTab(
									selected = pagerState.currentPage == index,
									onClick = {
										coroutineScope.launch {
											pagerState.animateScrollToPage(index)
										}
									},
									selectedContentColor = selectedColor,
									unselectedContentColor = unselectedColor,
									text = {
										Text(
											text = stringResource(id = tab.title),
											maxLines = 1,
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

						else -> {
							tabs.forEachIndexed { index, tab ->
								Tab(
									selected = pagerState.currentPage == index,
									onClick = {
										coroutineScope.launch {
											pagerState.animateScrollToPage(index)
										}
									},
									selectedContentColor = selectedColor,
									unselectedContentColor = unselectedColor,
									text = {
										Text(
											text = stringResource(id = tab.title),
											maxLines = 1,
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
					}
				}
			}
		}
		HorizontalPager(
			state = pagerState,
			beyondBoundsPageCount = 6,
		) { index ->
			when (index) {
				0 -> {
					RectanglePage(windowSize = windowSize)
				}

				1 -> {
					CubePage(windowSize = windowSize)
				}

				2 -> {
					CylinderPage(windowSize = windowSize)
				}

				3 -> {
					HexagonalPage(windowSize = windowSize)
				}

				4 -> {
					BowFrontPage(windowSize = windowSize)
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CalculatorsTabRowPreview() {
	AquariumInformationTheme {
		TankVolumeTabRow(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CalculatorsTabRowPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		TankVolumeTabRow(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
	}
}