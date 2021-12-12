package com.example.core.remote.services


import com.example.core.remote.models.HeroApi
import com.example.core.remote.models.HeroStats
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HeroesSevice {
    @GET("./heroes")
    suspend fun getHeroesList(): List<HeroApi>

    @GET("./heroStats")
    suspend fun getHeroStats(): List<HeroStats>
}