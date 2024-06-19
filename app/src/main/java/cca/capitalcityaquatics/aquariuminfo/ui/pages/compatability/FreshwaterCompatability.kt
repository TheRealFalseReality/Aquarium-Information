package cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.compatability.CompatibilityData
import cca.capitalcityaquatics.aquariuminfo.data.compatability.FreshwaterDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CompatibilityDataList
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FishCompatibilityCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageViewLazy

@Composable
fun FreshwaterCompatibilityScreen() {
    PageViewLazy {
        CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
    }
}

@Preview(showBackground = true)
@Composable
fun FishCardPreview() {
    FishCompatibilityCard(
        compatibilityData = CompatibilityData(
            R.drawable.pleco,
            R.string.text_pleco,
            R.string.text_latin_pleco,
            R.string.text_app_errors,
            R.string.text_amount_fah,
            R.string.text_pleco,
            R.string.plecos_description
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    FreshwaterCompatibilityScreen()
}