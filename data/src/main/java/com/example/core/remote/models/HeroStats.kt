package com.example.core.remote.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable



data class HeroStats(
    val id: Int,
    val name: String,
    val localized_name: String,
    val img: String,
    val icon: String,
    val pro_win: Int,
    val pro_pick: Int,
    val hero_id: Int,
    val pro_ban: Int,
    @SerializedName("1_pick")
    val herald_pick: Int,
    @SerializedName("1_win")
    val herald_win: Int,
    @SerializedName("2_pick")
    val guardian_pick: Int,
    @SerializedName("2_win")
    val guardian_win: Int,
    @SerializedName("3_pick")
    val crusader_pick: Int,
    @SerializedName("3_win ")
    val crusader_win: Int,
    @SerializedName("4_pick")
    val archon_pick: Int,
    @SerializedName("4_win")
    val archon_win: Int,
    @SerializedName("5_pick")
    val legend_pick: Int,
    @SerializedName("5_win")
    val legend_win: Int,
    @SerializedName("6_pick")
    val ancient_pick: Int,
    @SerializedName("6_win")
    val ancient_win: Int,
    @SerializedName("7_pick")
    val divine_pick: Int,
    @SerializedName("7_win")
    val divine_win: Int,
    @SerializedName("8_pick")
    val immortal_pick: Int,
    @SerializedName("8_win")
    val immortal_win: Int,
    val turbo_pick: Int,
    val turbo_win: Int
)