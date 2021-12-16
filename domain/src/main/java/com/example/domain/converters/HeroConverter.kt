package com.example.domain.converters


import android.os.Parcel
import android.os.Parcelable
import com.example.core.remote.models.HeroApi
import com.example.core.remote.models.HeroStats
import com.example.core.storage.models.HeroEntity
import com.example.domain.models.Hero

class HeroConverter() {
    fun fromApiToUi(heroList: HeroApi, heroStats: HeroStats): Hero {
        return Hero(
            id = heroList.id,
            attackType = heroList.attack_type,
            avatar = heroStats.img,
            attributes = heroList.primary_attr,
            roles = heroList.roles.toString(),
            isChosen = false,
            heroName = heroStats.localized_name,
            herald_pick = heroStats.herald_pick,
            herald_win = heroStats.herald_win,
            guardian_pick = heroStats.guardian_pick,
            guardian_win = heroStats.guardian_win,
            crusader_pick = heroStats.crusader_pick,
            crusader_win = heroStats.crusader_win,
            archon_pick = heroStats.archon_pick,
            archon_win = heroStats.archon_win,
            legend_pick = heroStats.legend_pick,
            legend_win = heroStats.legend_win,
            ancient_pick = heroStats.ancient_pick,
            ancient_win = heroStats.ancient_win,
            divine_pick = heroStats.divine_pick,
            divine_win = heroStats.divine_win,
            immortal_pick = heroStats.immortal_pick,
            immortal_win = heroStats.immortal_win,
            turbo_pick = heroStats.turbo_pick,
            turbo_win = heroStats.turbo_win
        )
    }

//    fun fromApiToDb(heroList: HeroApi, heroStats: HeroStats): HeroEntity {
//        return HeroEntity(
//            id = heroList.id,
//            displayName = heroStats.localized_name,
//            attackType = heroList.attack_type,
//            avatar = heroStats.img,
//            attributes = heroList.primary_attr,
//            roles = heroList.roles.toString(),
//            heroName = heroStats.localized_name
//        )
//    }

//    fun convertFromDbToDomain(heroEntity: HeroEntity): Hero {
//        return Hero(
//            id = heroEntity.id,
//            attackType = heroEntity.attackType,
//            avatar = heroEntity.avatar,
//            isChosen = false,
//            attributes = heroEntity.attributes,
//            roles = heroEntity.roles,
//            heroName = heroEntity.heroName,
//            herald_pick = 0,
//            herald_win = 0,
//            guardian_pick = 0,
//            guardian_win = 0,
//            crusader_pick = 0,
//            crusader_win = 0,
//            archon_pick = 0,
//            archon_win = 0,
//            legend_pick = 0,
//            legend_win = 0,
//            ancient_pick = 0,
//            ancient_win = 0,
//            divine_pick = 0,
//            divine_win = 0,
//            immortal_pick = 0,
//            immortal_win = 0,
//            turbo_pick = 0,
//            turbo_win = 0
//        )
//    }
}