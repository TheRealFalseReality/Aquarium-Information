package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun PageView(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.SpaceAround,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = verticalArrangement
    ) {
        content()
        VerticalSpacerSmall()
    }
}

@Composable
fun PageViewLazy(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        content()
    }
}

@Composable
fun GenericCalculatePage(
    windowSize: WindowSizeClass,
    subtitleContent: @Composable () -> Unit = {},
    selectContent: @Composable () -> Unit = {},
    optionsContent: @Composable () -> Unit = {},
    inputFieldContent: @Composable () -> Unit,
    calculateFieldContent: @Composable () -> Unit,
    additionalContent: @Composable (() -> Unit)? = null,
    formulaContent: @Composable (() -> Unit)? = null,
) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            subtitleContent()
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
						.heightIn(min = dimensionResource(id = R.dimen.landscape_column_height))
						.weight(3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    VerticalSpacerSmall()
                    selectContent()
                    VerticalSpacerSmall()
                    optionsContent()
                    VerticalSpacerSmall()
                    inputFieldContent()
                }
                Column(
                    modifier = Modifier
						.heightIn(min = dimensionResource(id = R.dimen.landscape_column_height))
						.weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    calculateFieldContent()
                }
            }
            VerticalSpacerMedium()
            Row(
                verticalAlignment = Alignment.Top
            ) {
                if (additionalContent != null) {
                    Column(
                        modifier = Modifier
                            .weight(3f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        additionalContent()
                    }
                    Column(
                        modifier = Modifier.weight(2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        if (formulaContent != null) {
                            formulaContent()
                        }
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        if (formulaContent != null) {
                            formulaContent()
                        }
                    }
                }
            }
        }

        else -> {
            subtitleContent()
            VerticalSpacerSmall()
            selectContent()
            VerticalSpacerSmall()
            optionsContent()
            VerticalSpacerSmall()
            inputFieldContent()
            VerticalSpacerMedium()
            calculateFieldContent()
            VerticalSpacerSmall()
            if (additionalContent != null) {
                additionalContent()
            }
            VerticalSpacerSmall()
            if (formulaContent != null) {
                formulaContent()
            }
        }
    }
}