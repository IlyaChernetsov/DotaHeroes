package com.example.dotaheroes.business

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroUi(
    val id: Int,
    val attackType: String,
    val avatar: String,
    val isChosen: Boolean = false,
    val attributes: String,
    val roles: List<String>,
    val heroName: String,
    val heroBackGroundColor: Int,
    val heroAttrIcon: Int

) : Parcelable