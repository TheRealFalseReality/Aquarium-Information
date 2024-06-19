package cca.capitalcityaquatics.aquariuminfo.data.tankvolumes

import cca.capitalcityaquatics.aquariuminfo.R

val cylinderDataSource =
    TankVolumeData(
        inputTextFeet = R.string.text_amount_DH_feet,
        inputTextInches = R.string.text_amount_DH_inches,
        formulaText = R.string.text_formula_vol_cylinder,
        image = R.drawable.cylinder_calc,
    )

val bowFrontDataSource =
    TankVolumeData(
        inputTextFeet = R.string.text_amount_LWHFW_feet,
        inputTextInches = R.string.text_amount_LWHFW_inches,
        formulaText = R.string.text_formula_soon,
        image = R.drawable.bowfront_calc,
    )

val hexagonalDataSource =
    TankVolumeData(
        inputTextFeet = R.string.text_amount_EH_feet,
        inputTextInches = R.string.text_amount_EH_inches,
        formulaText = R.string.text_formula_soon,
        image = R.drawable.hexagonal_prism,
    )

val rectangleDataSource =
    TankVolumeData(
        inputTextFeet = R.string.text_amount_LWH,
        inputTextInches = R.string.text_amount_LWH_inches,
        formulaText = R.string.text_formula_vol_rec,
        image = R.drawable.rectangle_calc,
    )

val cubeDataSource =
    TankVolumeData(
        inputTextFeet = R.string.text_amount_length_side_feet,
        inputTextInches = R.string.text_amount_length_side_inches,
        formulaText = R.string.text_formula_vol_cube,
        image = R.drawable.cube_calc,
    )