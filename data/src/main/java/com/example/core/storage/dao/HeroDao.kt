package com.example.core.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.storage.contracts.RoomContract
import com.example.core.storage.models.HeroEntity

@Dao
interface HeroDao {

    @Query(value = "SELECT * FROM ${RoomContract.tableHeroes}")
    fun fetchHeroes(): List<HeroEntity>

    @Insert(entity = HeroEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun addHero(heroEntity: HeroEntity)
}