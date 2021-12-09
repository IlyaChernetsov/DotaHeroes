package com.example.domain.converters


import com.example.core.remote.models.HeroApi
import com.example.domain.models.Hero

class HeroConverter {
    fun fromApiToUi(model: HeroApi): Hero{
        return Hero(
            id = model.id,
            heroName = model.name.replace("npc_dota_hero_", ""),
            attackType = model.attack_type
        )
    }
}