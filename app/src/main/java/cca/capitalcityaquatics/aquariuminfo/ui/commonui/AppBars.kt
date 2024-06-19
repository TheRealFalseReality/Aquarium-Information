package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.Destinations
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.Information
import cca.capitalcityaquatics.aquariuminfo.navigation.Overview
import cca.capitalcityaquatics.aquariuminfo.navigation.bottomNavRow
import cca.capitalcityaquatics.aquariuminfo.navigation.navigateSingleTopTo
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@ExperimentalMaterial3Api
@Composable
fun AquariumAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Box(
                modifier = Modifier
					.fillMaxWidth()
					.clickable {
						navController.navigateSingleTopTo(Overview.route)
					},
                contentAlignment = Alignment.Center
            ) {
                HeaderTextLarge(
                    text = R.string.app_name,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme
                .surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_small)),
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateSingleTopTo(Home.route)
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.home),
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    navController.navigateSingleTopTo(Information.route)
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_information),
                    contentDescription = stringResource(R.string.app_information),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    )
}

@Composable
fun BottomNavBar(
    allScreens: List<Destinations>,
    onTabSelected: (Destinations) -> Unit,
    currentScreen: Destinations,
) {
    NavigationBar {
        allScreens.forEach { screen ->
            NavigationBarItem(
                selected = currentScreen == screen,
                onClick = { onTabSelected(screen) },
                icon = {
                    Icon(
                        painter =
                        if (currentScreen != screen) painterResource(id = screen.icon)
                        else painterResource(id = screen.iconFilled),
                        stringResource(id = screen.title),
                    )
                },
                label = { Text(stringResource(id = screen.title)) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = MaterialTheme.colorScheme.secondary,
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.primary,
                ),
            )
        }
    }
}

@Composable
fun AppNavigationRail(
    modifier: Modifier = Modifier,
    allScreens: List<Destinations>,
    onTabSelected: (Destinations) -> Unit,
    currentScreen: Destinations,
) {
    NavigationRail(
        modifier = modifier
            .padding(end = dimensionResource(id = R.dimen.padding_verySmall)),
        containerColor = MaterialTheme.colorScheme
            .surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_small)),
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            allScreens.forEach { screen ->
                NavigationRailItem(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_extremelySmall)),
                    icon = {
                        Icon(
                            painter =
                            if (currentScreen != screen) painterResource(id = screen.icon)
                            else painterResource(id = screen.iconFilled),
                            stringResource(id = screen.title),
                        )
                    },
                    label = { Text(stringResource(id = screen.title)) },
                    selected = currentScreen == screen,
                    onClick = { onTabSelected(screen) },
                    alwaysShowLabel = false,
                    colors = NavigationRailItemDefaults.colors(
                        selectedTextColor = MaterialTheme.colorScheme.secondary,
                        selectedIconColor = MaterialTheme.colorScheme.secondary,
                        unselectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun NavBarPreview() {
    AquariumInformationTheme {
        val navController = rememberNavController()
        AppNavigationRail(
            allScreens = bottomNavRow,
            onTabSelected = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)
            },
            currentScreen = Overview
        )
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    AquariumInformationTheme {
        AquariumAppBar(navController = rememberNavController())
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        AquariumAppBar(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    AquariumInformationTheme {
        val navController = rememberNavController()
        BottomNavBar(
            allScreens = bottomNavRow,
            onTabSelected = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)
            },
            currentScreen = Overview
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreviewDark(
) {
    AquariumInformationTheme(useDarkTheme = true) {
        val navController = rememberNavController()
        BottomNavBar(
            allScreens = bottomNavRow,
            onTabSelected = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)
            },
            currentScreen = Overview
        )
    }
}