package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Hero(
    val id: Int,
    val attackType: String,
    val avatar: String,
    val isChosen: Boolean = false,
    val attributes: String,
    val roles: List<String>,
    val heroName: String
): Parcelable
