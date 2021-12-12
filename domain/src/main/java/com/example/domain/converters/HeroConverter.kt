package com.example.domain.converters


import com.example.core.remote.models.HeroApi
import com.example.core.remote.models.HeroStats
import com.example.domain.models.Hero

class HeroConverter {
    fun fromApiToUi(heroList: HeroApi, heroStats: HeroStats): Hero {
        return Hero(
            id = heroList.id,
            attackType = heroList.attack_type,
            avatar = heroStats.img,
            attributes = heroList.primary_attr,
            roles = heroList.roles,
            heroName = heroStats.localized_name
            )
    }
}