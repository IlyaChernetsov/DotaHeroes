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
            roles = hero.roles,
            heroName = hero.heroName,
            heroBackGroundColor = heroBackGround(hero),
            heroAttrIcon = heroAttrIcon(hero)

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
            "str" -> R.drawable.strength
            "agi" -> R.drawable.agility
            "int" -> R.drawable.intelect
            else -> R.drawable.ic_default_user
        }
    }

    fun heroBackGround(heroModel: Hero?): Int {
        return when (heroModel?.attributes) {
            "str" -> R.drawable.gradient_background_strength
            "agi" -> R.drawable.gradient_background_agility
            "int" -> R.drawable.gradient_background_intelect
            else -> R.drawable.ic_default_user
        }
    }
}
/*

               val newHeroStats = heroStats.map {
                    it.copy(
                        icon = "${RetrofitFactory.baseImg}${it.icon}",
                        img = "${RetrofitFactory.baseImg}${it.img}"
                    )
                }

                heroesList.map { hero -> heroConverter.fromApiToUi(
                    heroList = hero,
                    heroStats = newHeroStats.first{stats ->  stats.id == hero.id}
                ) }
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
val repository = HeroRepositoryImpl()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val fetchedHeroes = repository.fetchHeroes().await()
                if (fetchedHeroes.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        state.set(newValue = State.NoItemsState())
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        state.set(newValue = State.LoadedState(data = fetchedHeroes))
                        val a = state.set(newValue = State.LoadedState(data = fetchedHeroes))
                        val a1 = a
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "error ${e.localizedMessage}")
                e.printStackTrace()
            }
        }
    }
*/
