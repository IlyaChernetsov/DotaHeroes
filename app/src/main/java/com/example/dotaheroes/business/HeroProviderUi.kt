package com.example.dotaheroes.business

import com.example.domain.repositories.HeroRepositoryImpl
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.lang.Exception

class HeroProviderUi {
    private val heroConverterFromDomainToUi = HeroConverterFromDomainToUi()
    val repository = HeroRepositoryImpl()
    suspend fun fetchHeroesUI(): Deferred<List<HeroUi>> {
        return try {
            val heroesList = repository.fetchHeroes().await()
            return GlobalScope.async {
                heroesList.map { hero ->
                    heroConverterFromDomainToUi.fromDomainToUi(hero)
                }
            }
        } catch (e: Exception) {
            GlobalScope.async {
                error(e)
            }
        }
    }
}