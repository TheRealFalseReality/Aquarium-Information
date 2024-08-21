package cca.capitalcityaquatics.aquariuminfo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.AquariumNavHost
import cca.capitalcityaquatics.aquariuminfo.navigation.Destinations
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.Overview
import cca.capitalcityaquatics.aquariuminfo.navigation.bottomNavRow
import cca.capitalcityaquatics.aquariuminfo.navigation.navigateSingleTopTo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.AppNavigationRail
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.AquariumAppBar
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BottomNavBar
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            AquariumInformationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    AquariumInfoApp(windowSizeClass)
                }
            }
        }
    }
}

@Composable
fun AquariumInfoApp(
    windowSize: WindowSizeClass
) {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = bottomNavRow.firstOrNull {
        it.route == currentDestination?.route
    } ?: Overview


    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            AppLandscape(
                navController = navController,
                currentScreen = currentScreen,
                windowSize = windowSize,
            )
        }

        else -> {
            AppPortrait(
                navController = navController,
                currentScreen = currentScreen,
                windowSize = windowSize,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPortrait(
    windowSize: WindowSizeClass,
    navController: NavHostController,
    currentScreen: Destinations
) {
    Scaffold(
        topBar = {
            AquariumAppBar(navController = navController)
        },
        bottomBar = {
            BottomNavBar(
                allScreens = bottomNavRow,
                onTabSelected = { newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)
                },
                currentScreen = currentScreen,
            )
        },
    ) { innerPadding ->
        AquariumNavHost(
            windowSize = windowSize,
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun AppLandscape(
    windowSize: WindowSizeClass,
    navController: NavHostController,
    currentScreen: Destinations
) {
    Row {
        AppNavigationRail(
            allScreens = bottomNavRow,
            onTabSelected = { newScreen ->
                navController.navigateSingleTopTo(newScreen.route)
            },
            currentScreen = currentScreen,
        )
        AquariumNavHost(
            windowSize = windowSize,
            navController = navController,
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            AppPortrait(
                navController = rememberNavController(),
                currentScreen = Home,
                windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun AppDarkPreview() {
    AquariumInformationTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            AppPortrait(
                navController = rememberNavController(),
                currentScreen = Home,
                windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun AppLandscapePreview() {
    AquariumInformationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            AppLandscape(
                navController = rememberNavController(),
                currentScreen = Home,
                windowSize = WindowSizeClass.calculateFromSize(DpSize(700.dp, 400.dp))
            )
        }
    }
}