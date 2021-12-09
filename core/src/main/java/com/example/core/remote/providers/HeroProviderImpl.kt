package com.example.core.remote.providers


import com.example.core.helpers.RetrofitFactory
import com.example.core.remote.models.HeroApi


class HeroProviderImpl {
    suspend fun getHeroesList():List<HeroApi>{
        return RetrofitFactory.getHeroService().getHeroes()
    }
}