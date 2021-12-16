package com.example.core.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.storage.contracts.RoomContract
import com.example.core.storage.models.FavouriteHeroEntity


@Dao
interface FavouriteHeroDao {

    @Query(value = "SELECT * FROM ${RoomContract.tableFavouriteHeroes}")
    fun fetchHeroes(): List<FavouriteHeroEntity>

    @Insert(entity = FavouriteHeroEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun addHero(favouriteHeroEntity: FavouriteHeroEntity)

    @Query("DELETE FROM ${RoomContract.tableFavouriteHeroes} WHERE :id like id")
    fun deleteHero(id: Int)

}