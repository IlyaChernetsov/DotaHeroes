package com.example.domain.repositories


import com.example.core.helpers.RetrofitFactory
import com.example.core.remote.providers.HeroProviderImpl
import com.example.domain.converters.HeroConverter
import com.example.domain.models.Hero
import kotlinx.coroutines.*
import java.lang.Exception

class HeroRepositoryImpl() {
    private val heroConverter: HeroConverter = HeroConverter()
    private val heroProviderImpl: HeroProviderImpl = HeroProviderImpl()
    suspend fun fetchHeroes(): Deferred<List<Hero>> {
        return try {
            val heroesList = heroProviderImpl.getHeroesList()
            val heroStats = heroProviderImpl.getHeroesStats()

            return GlobalScope.async {
                heroStats.map {
                    it.icon = "${RetrofitFactory.baseImg}${it.icon}"
                    it.img = "${RetrofitFactory.baseImg}${it.img}"
                    it
                }

                heroesList.map { hero -> heroConverter.fromApiToUi(
                    heroList = hero,
                    heroStats = heroStats.first{stats ->  stats.id == hero.id}
                ) }
            }
        } catch (e: Exception) {
            GlobalScope.async {
                error(e)
            }
        }
    }
}