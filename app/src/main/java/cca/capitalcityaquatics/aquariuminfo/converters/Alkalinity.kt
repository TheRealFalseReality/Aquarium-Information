package cca.capitalcityaquatics.aquariuminfo.converters

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun AlkalinityScreen(
    modifier: Modifier = Modifier,
) {
    var inputAlk by rememberSaveable {
        mutableStateOf("14")
    }
    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_dkh)
    }

    val alk = inputAlk.toDoubleOrNull() ?: 0.0
    val ppmDKH = calculatePpmDkh(alk).toDoubleOrNull() ?: 0.0
    val dkhPPM = calculateDkhPpm(alk).toDoubleOrNull() ?: 0.0
    val meqDKH = calculateMeqDkh(alk).toDoubleOrNull() ?: 0.0
    val meqPPM = calculateMeqPpm(alk).toDoubleOrNull() ?: 0.0
    val ppmMEQ = calculatePpmMeq(alk).toDoubleOrNull() ?: 0.0
    val dkhMEQ = calculateDkhMeq(alk).toDoubleOrNull() ?: 0.0

    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(bottom = 86.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                    shape = RoundedCornerShape(4.dp)
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                GeneralComposeHeader(textHeader = R.string.text_title_alk)

                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_alk)

                RadioButtonCard3(
                    text1 = R.string.button_label_dkh,
                    text2 = R.string.button_label_ppm,
                    text3 = R.string.button_label_meq,
                    onClick1 = { selected = R.string.button_label_dkh },
                    onClick2 = { selected = R.string.button_label_ppm },
                    onClick3 = { selected = R.string.button_label_meq },
                    selected = selected
                )

                    when (selected) {
                        R.string.button_label_dkh -> {
                            DataOutputLines4(
                                value = inputAlk,
                                label = R.string.field_label_dkh,
                                onValueChange = { inputAlk = it },
                                inputText = R.string.text_amount_dkh,
                                equalsText = R.string.text_equal_to,
                                outputTextA = R.string.text_amount_ppm,
                                valueA = ppmDKH,
                                outputTextB = R.string.text_amount_meq,
                                valueB = meqDKH
                            )
                            
                            WaterHardnessDKH(ppmDKH)

                        }
                        R.string.button_label_ppm -> {
                            DataOutputLines4(
                                value = inputAlk,
                                label = R.string.field_label_ppm,
                                onValueChange = { inputAlk = it },
                                inputText = R.string.text_amount_ppm,
                                equalsText = R.string.text_equal_to,
                                outputTextA = R.string.text_amount_dkh,
                                valueA = dkhPPM,
                                outputTextB = R.string.text_amount_meq,
                                valueB = meqPPM
                            )
                            
                            WaterHardnessPPM(dkhPPM)
                            
                        }
                        R.string.button_label_meq -> {
                            DataOutputLines4(
                                value = inputAlk,
                                label = R.string.field_label_meq,
                                onValueChange = { inputAlk = it },
                                inputText = R.string.text_amount_meq,
                                equalsText = R.string.text_equal_to,
                                outputTextA = R.string.text_amount_dkh,
                                valueA = dkhMEQ,
                                outputTextB =  R.string.text_amount_ppm,
                                valueB = ppmMEQ
                            )

                            WaterHardnessMEQ(ppmMEQ)

                        }
                    }
                
                FormulaString(text = R.string.text_formula_alk)

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                ImageGeneral(
                    image = R.drawable.screenshot_20220618_122436,
                    contDesc = R.string.text_water_hardness_chart
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

            }
        }
    }
}

@Composable
fun WaterHardnessDKH(
    ppmDKH: Double,
) {
    val vSoft = stringResource(id = R.string.text_hardness_very_soft)
    val soft = stringResource(id = R.string.text_hardness_soft)
    val modHard = stringResource(id = R.string.text_hardness_mod_hard)
    val hard = stringResource(id = R.string.text_hardness_hard)
    val veryHard = stringResource(id = R.string.text_hardness_very_hard)
    val outBounds = stringResource(id = R.string.text_hardness_else)

    when (ppmDKH) {
        in 0.0..70.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, vSoft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ic_vsoftdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_soft)
            )
        }
        in 70.1..140.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, soft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.softdkh),
                contentDescription = stringResource(id = R.string.text_hardness_soft)
            )
        }
        in 140.1..210.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, modHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.mhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
            )
        }
        in 210.1..320.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, hard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.hardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_hard)
            )
        }
        in 320.1..530.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, veryHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.vhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
        else -> {
            Text(text = stringResource(id = R.string.text_hardness_label, outBounds))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.outdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
    }
}

@Composable
fun WaterHardnessPPM(
    dkhPPM: Double,
) {
    val vSoft = stringResource(id = R.string.text_hardness_very_soft)
    val soft = stringResource(id = R.string.text_hardness_soft)
    val modHard = stringResource(id = R.string.text_hardness_mod_hard)
    val hard = stringResource(id = R.string.text_hardness_hard)
    val veryHard = stringResource(id = R.string.text_hardness_very_hard)
    val outBounds = stringResource(id = R.string.text_hardness_else)

    when (dkhPPM) {
        in 0.0..4.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, vSoft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ic_vsoftdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_soft)
            )
        }
        in 4.1..8.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, soft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.softdkh),
                contentDescription = stringResource(id = R.string.text_hardness_soft)
            )
        }
        in 8.1..12.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, modHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.mhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
            )
        }
        in 12.1..18.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, hard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.hardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_hard)
            )
        }
        in 18.1..30.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, veryHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.vhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
        else -> {
            Text(text = stringResource(id = R.string.text_hardness_label, outBounds))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.outdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
    }
}

@Composable
fun WaterHardnessMEQ(
    ppmMEQ: Double,
) {
    val vSoft = stringResource(id = R.string.text_hardness_very_soft)
    val soft = stringResource(id = R.string.text_hardness_soft)
    val modHard = stringResource(id = R.string.text_hardness_mod_hard)
    val hard = stringResource(id = R.string.text_hardness_hard)
    val veryHard = stringResource(id = R.string.text_hardness_very_hard)
    val outBounds = stringResource(id = R.string.text_hardness_else)

    when (ppmMEQ) {
        in 0.0..70.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, vSoft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ic_vsoftdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_soft)
            )
        }
        in 70.1..140.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, soft))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.softdkh),
                contentDescription = stringResource(id = R.string.text_hardness_soft)
            )
        }
        in 140.1..210.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, modHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.mhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
            )
        }
        in 210.1..320.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, hard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.hardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_hard)
            )
        }
        in 320.1..530.0 -> {
            Text(text = stringResource(R.string.text_hardness_label, veryHard))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.vhardtdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
        else -> {
            Text(text = stringResource(id = R.string.text_hardness_label, outBounds))
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.outdkh),
                contentDescription = stringResource(id = R.string.text_hardness_very_hard)
            )
        }
    }
}

@VisibleForTesting
internal fun calculatePpmDkh(
    alk: Double,
): String{
    val ppmDKH = alk * 17.857
    val df = DecimalFormat("#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(ppmDKH)
}

@VisibleForTesting
internal fun calculateMeqDkh(
    alk: Double,
): String{
    val meqDKH = alk * 0.357
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(meqDKH)
}

@VisibleForTesting
internal fun calculateDkhPpm(
    alk: Double,
): String{
    val dkhPPM = alk * 0.056
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(dkhPPM)
}

@VisibleForTesting
internal fun calculateMeqPpm(
    alk: Double,
): String{
    val meqPPM = alk * 0.02
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(meqPPM)
}

@VisibleForTesting
internal fun calculatePpmMeq(
    alk: Double,
): String{
    val ppmMEQ = alk * 50
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(ppmMEQ)
}

@VisibleForTesting
internal fun calculateDkhMeq(
    alk: Double,
): String{
    val dkhMEQ = alk * 2.8
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(dkhMEQ)
}

@Preview(showBackground = true)
@Composable
fun AlkPreview() {
    AquariumInfoTheme {
        AlkalinityScreen()
    }
}