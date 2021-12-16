package com.example.dotaheroes.business

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.domain.repositories.HeroRepositoryImpl
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.lang.Exception

class HeroProviderUi() {
    private val heroConverterFromDomainToUi = HeroConverterFromDomainToUi()
    val repository = HeroRepositoryImpl()
    suspend fun fetchHeroesUI(): Deferred<List<HeroUi>> {
        return try {
            val remoteHeroesList = repository.fetchHeroes().await()
            return GlobalScope.async {
                remoteHeroesList.map { hero ->
                    heroConverterFromDomainToUi.fromDomainToUi(hero)
                }
            }
        } catch (e: Exception) {
            GlobalScope.async {
                error(e)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}