package com.example.domain.models

import kotlinx.serialization.Serializable

data class Hero(
    val id: Int,
    val attackType: String,
    val avatar: String,
    val attributes: String,
    val isChosen: Boolean,
    val roles: String,
    val heroName: String,
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
)
