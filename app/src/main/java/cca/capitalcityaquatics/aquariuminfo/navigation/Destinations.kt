package cca.capitalcityaquatics.aquariuminfo.navigation

import cca.capitalcityaquatics.aquariuminfo.R

interface Destinations {
    val icon: Int
    val iconFilled: Int
    val route: String
    val title: Int
}

object Home : Destinations {
    override val icon = R.drawable.ic_home
    override val iconFilled = R.drawable.ic_home_filled
    override val route = "home"
    override val title = R.string.home
}

object Information : Destinations {
    override val icon = R.drawable.ic_information
    override val iconFilled = R.drawable.ic_information_filled
    override val route = "info"
    override val title = R.string.text_title_info
}

object Overview : Destinations {
    override val icon = R.drawable.ic_grid
    override val iconFilled = R.drawable.ic_grid_filled
    override val route = "overview"
    override val title = R.string.overview
}

object TankVolume : Destinations {
    override val icon = R.drawable.ic_volume
    override val iconFilled = R.drawable.ic_volume
    override val route = "volume"
    override val title = R.string.tank_volume
}

object Salinity : Destinations {
    override val icon = R.drawable.ic_salinity_alt
    override val iconFilled = R.drawable.ic_salinity_filled
    override val route = "salinity"
    override val title = R.string.salinity
}

object Alkalinity : Destinations {
    override val icon = R.drawable.ic_tds
    override val iconFilled = R.drawable.ic_tds_filled
    override val route = "alkalinity"
    override val title = R.string.alkalinity
}

//
object Temperature : Destinations {
    override val icon = R.drawable.ic_thermostat
    override val iconFilled = R.drawable.ic_thermostat
    override val route = "temp"
    override val title = R.string.temperature
}

//
object CarbonDioxide : Destinations {
    override val icon = R.drawable.ic_co2
    override val iconFilled = R.drawable.ic_co2
    override val route = "carbon"
    override val title = R.string.carbon_dioxide
}

object Rectangle : Destinations {
    override val icon = R.drawable.ic_rectangle
    override val iconFilled = R.drawable.ic_rectangle
    override val route = "rectangle"
    override val title = R.string.text_title_rectangle
}

object Cube : Destinations {
    override val icon = R.drawable.ic_cube_2
    override val iconFilled = R.drawable.ic_cube_2
    override val route = "cube"
    override val title = R.string.text_title_cube
}

object Cylinder : Destinations {
    override val icon = R.drawable.ic_cylinder
    override val iconFilled = R.drawable.ic_cylinder
    override val route = "cylinder"
    override val title = R.string.text_title_cyl
}

object Hexagonal : Destinations {
    override val icon = R.drawable.ic_hex
    override val iconFilled = R.drawable.ic_hex
    override val route = "hexagonal"
    override val title = R.string.text_title_hex
}

object BowFront : Destinations {
    override val icon = R.drawable.ic_bow_front
    override val iconFilled = R.drawable.ic_bow_front
    override val route = "bow_front"
    override val title = R.string.text_title_bow_front
}

object FishCompatibility : Destinations {
    override val icon = R.drawable.ic_meal
    override val iconFilled = R.drawable.ic_meal_filled
    override val route = "fish_compatibility"
    override val title = R.string.compatibility
}

object FishCompatibilityFreshwater : Destinations {
    override val icon = R.drawable.ic_waves
    override val iconFilled = R.drawable.ic_waves
    override val route = "fish_compat_fresh"
    override val title = R.string.freshwater
}

object FishCompatibilityMarine : Destinations {
    override val icon = R.drawable.ic_water_lux
    override val iconFilled = R.drawable.ic_water_lux_filled
    override val route = "fish_compat_marine"
    override val title = R.string.marine
}

object Converters : Destinations {
    override val icon = R.drawable.ic_conversion
    override val iconFilled = R.drawable.ic_conversion
    override val route = "converters"
    override val title = R.string.converters
}

object Calculators : Destinations {
    override val icon = R.drawable.ic_calculate
    override val iconFilled = R.drawable.ic_calculate_filled
    override val route = "calculators"
    override val title = R.string.calculators
}

object HomeInfo : Destinations {
    override val icon = R.drawable.ic_home
    override val iconFilled = R.drawable.ic_home
    override val route = "home_info"
    override val title = R.string.more_information
}

object Doser : Destinations {
    override val icon = R.drawable.ic_sanitizer
    override val iconFilled = R.drawable.ic_sanitizer_filled
    override val route = "dosing"
    override val title = R.string.dosing
}

object PumpFlow : Destinations {
    override val icon = R.drawable.ic_water_pump
    override val iconFilled = R.drawable.ic_water_pump_filled
    override val route = "pump"
    override val title = R.string.pump_flow
}

val bottomNavRow = listOf(Overview, Calculators, TankVolume, FishCompatibility)
val compatibilityTabRow = listOf(FishCompatibilityFreshwater, FishCompatibilityMarine)
val calculatorsTabRow = listOf(
    Salinity,
    Alkalinity,
    Temperature,
    CarbonDioxide,
    Doser,
    PumpFlow
) // TODO Alter TabRow on Views when 6 or more
val tankVolumeTabRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
