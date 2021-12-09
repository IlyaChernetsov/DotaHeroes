package com.example.domain.repositories


import android.util.Log
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
            val heroes = heroProviderImpl.getHeroesList()
            return GlobalScope.async {
                heroes.map { hero -> heroConverter.fromApiToUi(model = hero) }
            }
        } catch (e: Exception) {
            GlobalScope.async {
                error(e)
            }
        }
    }
}