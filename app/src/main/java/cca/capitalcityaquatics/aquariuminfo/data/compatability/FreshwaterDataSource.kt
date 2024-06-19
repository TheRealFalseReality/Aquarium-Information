package cca.capitalcityaquatics.aquariuminfo.data.compatability

import cca.capitalcityaquatics.aquariuminfo.R

class FreshwaterDataSource {
    fun loadFishCardsFreshwaterDataSource(): List<CompatibilityData> {
        return listOf(
            // Mbuna
            CompatibilityData(
                R.drawable.mbuba_cichlid,
                R.string.text_malawi,
                R.string.text_latin_cichlid_various,
                R.string.list_compatible_malawi,
                R.string.list_caution_malawi,
                R.string.list_incompatible_malawi,
                R.string.mbuna_description
            ),
            // Tanganyikan
            CompatibilityData(
                R.drawable.tanganyikan,
                R.string.text_tanganyikan,
                R.string.text_latin_cichlid_various,
                R.string.list_compatible_tanganyikan,
                R.string.list_caution_tanganyikan,
                R.string.list_incompatible_tanganyikan,
                R.string.tanganyikan_description
            ),
            // Misc. African
//			CompatibilityData(
//				R.drawable.misc_african,
//				R.string.text_african_cichlid,
//				R.string.text_latin_cichlid_various,
//				R.string.list_compatible_african_cichlid,
//				R.string.list_caution_african_cichlid,
//				R.string.list_incompatible_african_cichlid,
//				R.string.misc_cichlid_description
//			),
            // American Cichlids
            CompatibilityData(
                R.drawable.american_cichlid,
                R.string.text_cichlids_american,
                R.string.text_latin_cichlid_various,
                R.string.list_compatible_cichlids_american,
                R.string.list_caution_cichlids_american,
                R.string.list_incompatible_cichlids_american,
                R.string.american_cichlid_description
            ),
            // Angelfish
            CompatibilityData(
                R.drawable.angelfish,
                R.string.text_angelfish,
                R.string.text_latin_angelfish,
                R.string.list_compatible_angelfish,
                R.string.list_caution_angelfish,
                R.string.list_incompatible_angelfish,
                R.string.freshwater_angelfish_description
            ),
            // Barb
            CompatibilityData(
                R.drawable.barb,
                R.string.text_barbs,
                R.string.text_latin_barb,
                R.string.list_compatible_barb,
                R.string.list_caution_barb,
                R.string.list_incompatible_barb,
                R.string.barb_description
            ),
            // Betta
            CompatibilityData(
                R.drawable.betta,
                R.string.text_betta,
                R.string.text_latin_betta,
                R.string.list_compatible_betta,
                R.string.list_caution_betta,
                R.string.list_incompatible_betta,
                R.string.betta_description
            ),
            // Cory Cats
            CompatibilityData(
                R.drawable.cory_cats,
                R.string.text_cory_cats,
                R.string.text_latin_cory,
                R.string.list_compatible_cory,
                R.string.list_caution_cory,
                R.string.list_incompatible_cory,
                R.string.cory_cats_description
            ),
            // Danios / Minnows
            CompatibilityData(
                R.drawable.danios,
                R.string.text_danios,
                R.string.text_latin_danio,
                R.string.list_compatible_danios,
                R.string.list_caution_danios,
                R.string.list_incompatible_danios,
                R.string.danio_description
            ),
            // Discus
            CompatibilityData(
                R.drawable.discus,
                R.string.text_discus,
                R.string.text_latin_discus,
                R.string.list_compatible_discus,
                R.string.list_caution_discus,
                R.string.list_incompatible_discus,
                R.string.discus_description
            ),
            // Fancy Goldfish
            CompatibilityData(
                R.drawable.fancy_goldfish,
                R.string.text_fancy_goldfish,
                R.string.text_latin_fancy_goldfish,
                R.string.list_compatible_fancy_goldfish,
                R.string.list_caution_fancy_goldfish,
                R.string.list_incompatible_fancy_goldfish,
                R.string.goldfish_description
            ),
            // Gouramis
            CompatibilityData(
                R.drawable.gourami,
                R.string.text_gouramis,
                R.string.text_latin_gourami,
                R.string.list_compatible_gourami,
                R.string.list_caution_gourami,
                R.string.list_incompatible_gourami,
                R.string.gourami_description
            ),
            // Guppy
            CompatibilityData(
                R.drawable.guppy,
                R.string.text_guppies,
                R.string.text_latin_poecilia,
                R.string.list_compatible_guppies,
                R.string.list_caution_guppies,
                R.string.list_incompatible_guppies,
                R.string.guppy_description
            ),
            // Hatchets
            CompatibilityData(
                R.drawable.hatchets,
                R.string.text_hatchets,
                R.string.text_latin_hatchet,
                R.string.list_compatible_hatchets,
                R.string.list_caution_hatchets,
                R.string.list_incompatible_hatchets,
                R.string.hatchets_description
            ),
            // Killifish
            CompatibilityData(
                R.drawable.killifish,
                R.string.text_killifish,
                R.string.text_latin_killifish,
                R.string.list_compatible_killifish,
                R.string.list_caution_killifish,
                R.string.list_incompatible_killifish,
                R.string.killifish_description
            ),
            // Larger Catfish
            CompatibilityData(
                R.drawable.large_catfish,
                R.string.text_catfish,
                R.string.text_latin_larger_catfish,
                R.string.list_compatible_catfish,
                R.string.list_caution_catfish,
                R.string.list_incompatible_catfish,
                R.string.catfish_description
            ),
            // Loach
            CompatibilityData(
                R.drawable.loaches,
                R.string.text_loach,
                R.string.text_latin_loach,
                R.string.list_compatible_loach,
                R.string.list_caution_loach,
                R.string.list_incompatible_loach,
                R.string.loaches_description
            ),
            // Molly
            CompatibilityData(
                R.drawable.molly,
                R.string.text_molly,
                R.string.text_latin_poecilia,
                R.string.list_compatible_molly,
                R.string.list_caution_molly,
                R.string.list_incompatible_molly,
                R.string.mollies_description
            ),
            // Platy
            CompatibilityData(
                R.drawable.platy,
                R.string.text_platy,
                R.string.text_latin_platy,
                R.string.list_compatible_platy,
                R.string.list_caution_platy,
                R.string.list_incompatible_platy,
                R.string.platy_description
            ),
            // Pleco
            CompatibilityData(
                R.drawable.pleco,
                R.string.text_pleco,
                R.string.text_latin_pleco,
                R.string.list_compatible_pleco,
                R.string.list_caution_pleco,
                R.string.list_incompatible_pleco,
                R.string.plecos_description,
            ),
            // Rainbowfish
            CompatibilityData(
                R.drawable.rainbowfish,
                R.string.text_rainbowfish,
                R.string.text_latin_rainbowfish,
                R.string.list_compatible_rainbowfish,
                R.string.list_caution_rainbowfish,
                R.string.list_incompatible_rainbowfish,
                R.string.rainbowfish_description
            ),
            // Rasboras
            CompatibilityData(
                R.drawable.rasbora,
                R.string.text_rasboras,
                R.string.text_latin_rasbora,
                R.string.list_compatible_rasboras,
                R.string.list_caution_rasboras,
                R.string.list_incompatible_rasboras,
                R.string.rasboras_description
            ),
            // Freshwater Sharks
            CompatibilityData(
                R.drawable.freshwater_shark,
                R.string.text_freshwater_shark,
                R.string.text_latin_shark,
                R.string.list_compatible_shark,
                R.string.list_caution_shark,
                R.string.list_incompatible_shark,
                R.string.freshwater_shark_description
            ),
            // Suckermouth Catfish
//			CompatibilityData(
//				R.drawable.suckermouth_catfish,
//				R.string.text_sucker_catfish,
//				R.string.text_latin_larger_catfish,
//				R.string.list_compatible_suckermouth_catfish,
//				R.string.list_caution_suckermouth_catfish,
//				R.string.list_incompatible_suckermouth_catfish
//			),
            // Swordtails
            CompatibilityData(
                R.drawable.swordtail,
                R.string.text_swordtail,
                R.string.text_latin_swordtail,
                R.string.list_compatible_swordtail,
                R.string.list_caution_swordtail,
                R.string.list_incompatible_swordtail,
                R.string.swordtails_description
            ),
            // Tetras
            CompatibilityData(
                R.drawable.tetra,
                R.string.text_tetra,
                R.string.text_latin_tetra,
                R.string.list_compatible_tetra,
                R.string.list_caution_tetra,
                R.string.list_incompatible_tetra,
                R.string.tetras_description
            ),
            // Misc. Fish
            CompatibilityData(
                R.drawable.misc_fish,
                R.string.text_misc_fish,
                R.string.text_latin_various,
                R.string.list_compatible_misc,
                R.string.list_caution_misc,
                R.string.list_incompatible_misc,
                R.string.misc_fish_description
            ),
            // Invertebrates
            CompatibilityData(
                R.drawable.shrimp,
                R.string.text_inverts,
                R.string.text_latin_various,
                R.string.list_compatible_inverts,
                R.string.list_caution_inverts,
                R.string.list_incompatible_inverts,
                R.string.freshwater_inverts_description
            ),
            // Brackish Fish
            CompatibilityData(
                R.drawable.brackish,
                R.string.text_brackish,
                R.string.text_latin_various,
                R.string.list_compatible_brackish,
                R.string.list_caution_brackish,
                R.string.list_incompatible_brackish,
                R.string.brackish_description
            ),
            // Pond Fish
            CompatibilityData(
                R.drawable.koi,
                R.string.text_pond,
                R.string.text_latin_pond_fish,
                R.string.list_compatible_pond,
                R.string.list_caution_pond,
                R.string.list_incompatible_pond,
                R.string.koi_description
            ),
            // Freshwater Plants
            CompatibilityData(
                R.drawable.java_fern,
                R.string.text_freshwater_plants,
                R.string.text_latin_various,
                R.string.list_compatible_freshwater_plants,
                R.string.list_caution_freshwater_plants,
                R.string.list_incompatible_freshwater_plants,
                R.string.freshwater_plants_description
            ),
        )
    }
}