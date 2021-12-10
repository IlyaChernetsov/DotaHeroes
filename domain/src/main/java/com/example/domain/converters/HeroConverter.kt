package com.example.domain.converters


import com.example.core.remote.models.HeroApi
import com.example.core.remote.models.HeroStats
import com.example.domain.models.Hero

class HeroConverter {
    fun fromApiToUi(heroList: HeroApi, heroStats: HeroStats): Hero{
        return Hero(
            id = heroList.id,
            heroName = heroList.name.replace("npc_dota_hero_", ""),
            attackType = heroList.attack_type,
            avatar = heroStats.img
        )
    }
}