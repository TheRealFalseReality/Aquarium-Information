package cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.compatability.CompatibilityData
import cca.capitalcityaquatics.aquariuminfo.data.compatability.MarineDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CompatibilityDataList
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FishCompatibilityCard
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageViewLazy

@Composable
fun MarineCompatibilityScreen() {
    PageViewLazy {
        CompatibilityDataList(MarineDataSource().loadFishCardsMarineDataSource())
    }
}

@Preview(showBackground = true)
@Composable
fun FishCardCompatibilityDataPreview() {
    FishCompatibilityCard(
        compatibilityData = CompatibilityData(
            R.drawable.dwarf_angel,
            R.string.text_dwarf_angels,
            R.string.text_latin_dwarf_angels,
            R.string.list_compatible_dwarf_angels,
            R.string.list_caution_dwarf_angels,
            R.string.list_incompatible_dwarf_angels,
            R.string.plecos_description
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ListCompatibilityDataPreview() {
    MarineCompatibilityScreen()
}