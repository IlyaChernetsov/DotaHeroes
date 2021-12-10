package com.example.core.remote.providers


import com.example.core.helpers.RetrofitFactory
import com.example.core.remote.models.HeroApi
import com.example.core.remote.models.HeroStats


class HeroProviderImpl {
    suspend fun getHeroesList():List<HeroApi>{
        return RetrofitFactory.getHeroService().getHeroesList()
    }
    suspend fun getHeroesStats():List<HeroStats>{
        return RetrofitFactory.getHeroService().getHeroStats()
    }
}