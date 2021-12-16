package com.example.core.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.storage.contracts.RoomContract
import com.example.core.storage.dao.FavouriteHeroDao
import com.example.core.storage.dao.HeroDao
import com.example.core.storage.models.FavouriteHeroEntity
import com.example.core.storage.models.HeroEntity
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [FavouriteHeroEntity::class, HeroEntity::class], version = 1)
public abstract class RoomAppDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun favouriteHeroDao(): FavouriteHeroDao

    companion object {

        fun buildDataSource(@ApplicationContext context: Context): RoomAppDatabase = Room.databaseBuilder(
            context,
            RoomAppDatabase::class.java,
            RoomContract.databaseApp
        ).build()
    }
}