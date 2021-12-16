package com.example.dotaheroes.business

import com.example.domain.models.Hero
import com.example.dotaheroes.R

class HeroConverterFromDomainToUi {
    fun fromDomainToUi(hero: Hero): HeroUi {
        return HeroUi(
            id = hero.id,
            attackType = hero.attackType,
            avatar = hero.avatar,
            isChosen = hero.isChosen,
            attributes = heroAttr(hero),
            roles = hero.roles.toString().replace("[","").replace("]", ""),
            heroName = hero.heroName,
            heroBackGroundColor = heroBackGround(hero),
            heroAttrIcon = heroAttrIcon(hero),
            herald_pick = hero.herald_pick,
            herald_win = hero.herald_win,
            guardian_pick = hero.guardian_pick,
            guardian_win = hero.guardian_win,
            crusader_pick = hero.crusader_pick,
            crusader_win = hero.crusader_win,
            archon_pick = hero.archon_pick,
            archon_win = hero.archon_win,
            legend_pick =  hero.legend_pick,
            legend_win = hero.legend_win,
            ancient_pick = hero.ancient_pick,
            ancient_win = hero.ancient_win,
            divine_pick = hero.divine_pick,
            divine_win = hero.divine_win,
            immortal_pick = hero.immortal_pick,
            immortal_win = hero.immortal_win,
            turbo_pick = hero.turbo_pick,
            turbo_win = hero.turbo_win,
            buttonBackGroundColor = heroButtonBackGround(hero)
        )
    }



    fun heroAttr(heroModel: Hero?): String {
        return when (heroModel?.attributes) {
            "str" -> "Strength"
            "agi" -> "Agility"
            "int" -> "Intellect"
            else -> "Not Founded"
        }
    }

    fun heroAttrIcon(heroModel: Hero?): Int {
        return return when (heroModel?.attributes) {
            "str" -> R.drawable.strength_attr
            "agi" -> R.drawable.agility_attr
            "int" -> R.drawable.intelect_attr
            else -> R.drawable.ic_default_user
        }
    }

    fun heroBackGround(heroModel: Hero?): Int {
        return when (heroModel?.attributes) {
            "str" -> R.drawable.strength_background
            "agi" -> R.drawable.agility_background
            "int" -> R.drawable.intelect_background
            else -> R.drawable.ic_default_user
        }
    }
    fun heroButtonBackGround(heroModel: Hero?): Int {
        return when (heroModel?.attributes) {
            "str" -> R.drawable.gradient_button_background_strength
            "agi" -> R.drawable.gradient_button_background_agility
            "int" -> R.drawable.gradient_button_background_intelect
            else -> R.drawable.ic_default_user
        }
    }

}