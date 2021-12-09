package com.example.core.remote.services


import com.example.core.remote.models.HeroApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HeroesSevice {
    @GET("./heroes")
    suspend fun getHeroes(): List<HeroApi>
}