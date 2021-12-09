package com.example.dotaheroes.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.domain.models.Hero
import com.example.domain.repositories.HeroRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroesListViewModel() : ViewModel() {
    private val TAG = HeroesListViewModel::class.java.simpleName
    private val _heroes = MutableLiveData<List<Hero>>()
    val heroes: LiveData<List<Hero>> = _heroes

    private val _selectedHero = MutableLiveData<List<Hero?>>()
    val selected: LiveData<List<Hero?>> = _selectedHero

    init {
        val repository = HeroRepositoryImpl()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val fetchedHeroes = repository.fetchHeroes().await()
                if (fetchedHeroes.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        Log.e(TAG, "no hero founded")
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        _heroes.postValue(fetchedHeroes)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "error ${e.localizedMessage}")
                e.printStackTrace()
            }
        }
    }

}
