package com.example.core.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.storage.contracts.RoomContract

@Entity(tableName = RoomContract.tableFavouriteHeroes)
data class FavouriteHeroEntity(
    @PrimaryKey val id: Int,
    val attackType: String,
    val avatar: Int,
    val attributes: String,
    val roles: String,
    val isChosen: Boolean,
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
    val turbo_win: Int,
)