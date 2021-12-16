package com.example.dotaheroes.business

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroUi(
    val id: Int,
    val attackType: String,
    val avatar: String,
    var isChosen: Boolean = false,
    val attributes: String,
    val roles: String,
    val heroName: String,
    val heroBackGroundColor: Int,
    val buttonBackGroundColor: Int,
    val heroAttrIcon: Int,

    val herald_pick: Int,
    val herald_win: Int,
    val guardian_pick: Int,
    val guardian_win: Int,
    val crusader_pick: Int,
    val crusader_win: Int,
    val archon_pick: Int,
    val archon_win: Int,
    val legend_pick: Int,
    val legend_win: Int,
    val ancient_pick: Int,
    val ancient_win: Int,
    val divine_pick: Int,
    val divine_win: Int,
    val immortal_pick: Int,
    val immortal_win: Int,
    val turbo_pick: Int,
    val turbo_win: Int

) : Parcelable