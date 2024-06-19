package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.pages.HomePage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.InfoPage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.OverviewPage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators.CalculatorsTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability.CompatibilityTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes.TankVolumeTabRow

@Composable
fun AquariumNavHost(
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = modifier,
    ) {
        composable(route = Home.route) {
            HomePage()
        }
        composable(route = Information.route) {
            InfoPage()
        }
        composable(route = Overview.route) {
            OverviewPage(
                windowSize = windowSize,
                onClickTemperature = {
                    navController.navigateSingleTopTo(Temperature.route)
                },
                onClickCo2 = {
                    navController.navigateSingleTopTo(CarbonDioxide.route)
                },
                onClickSalinity = {
                    navController.navigateSingleTopTo(Calculators.route)
                },
                onClickAlkalinity = {
                    navController.navigateSingleTopTo(Alkalinity.route)
                },
                onClickFreshwater = {
                    navController.navigateSingleTopTo(FishCompatibility.route)
                },
                onClickMarine = {
                    navController.navigateSingleTopTo(FishCompatibilityMarine.route)
                },
                onClickRectangle = {
                    navController.navigateSingleTopTo((TankVolume.route))
                },
                onClickCube = {
                    navController.navigateSingleTopTo(Cube.route)
                },
                onClickCylinder = {
                    navController.navigateSingleTopTo(Cylinder.route)
                },
                onClickHexagonal = {
                    navController.navigateSingleTopTo(Hexagonal.route)
                },
                onClickBowFront = {
                    navController.navigateSingleTopTo(BowFront.route)
                },
                onClickHome = {
                    navController.navigateSingleTopTo(Home.route)
                },
                onClickInformation = {
                    navController.navigateSingleTopTo(Information.route)
                },
                onClickDoser = {
                    navController.navigateSingleTopTo(Doser.route)
                },
                onClickPumpFlow = {
                    navController.navigateSingleTopTo(PumpFlow.route)
                }
            )
        }
        composable(route = Converters.route) {
            CalculatorsTabRow(windowSize = windowSize)
        }
        composable(route = Calculators.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 0)
        }
        composable(route = TankVolume.route) {
            TankVolumeTabRow(windowSize = windowSize, selectedState = 0)
        }
        composable(route = FishCompatibility.route) {
            CompatibilityTabRow(selectedState = 0)
        }
        composable(route = FishCompatibilityMarine.route) {
            CompatibilityTabRow(selectedState = 1)
        }
        composable(route = FishCompatibilityFreshwater.route) {
            CompatibilityTabRow(selectedState = 0)
        }
        composable(route = Temperature.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 2)
        }
        composable(route = CarbonDioxide.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 3)
        }
        composable(route = Alkalinity.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 1)
        }
        composable(route = Salinity.route) {
            CalculatorsTabRow(windowSize = windowSize)
        }
        composable(route = Rectangle.route) {
            TankVolumeTabRow(windowSize = windowSize)
        }
        composable(route = Cube.route) {
            TankVolumeTabRow(selectedState = 1, windowSize = windowSize)
        }
        composable(route = Hexagonal.route) {
            TankVolumeTabRow(selectedState = 3, windowSize = windowSize)
        }
        composable(route = Cylinder.route) {
            TankVolumeTabRow(selectedState = 2, windowSize = windowSize)
        }
        composable(route = BowFront.route) {
            TankVolumeTabRow(selectedState = 4, windowSize = windowSize)
        }
        composable(route = Doser.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 4)
        }
        composable(route = PumpFlow.route) {
            CalculatorsTabRow(windowSize = windowSize, selectedState = 5)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
