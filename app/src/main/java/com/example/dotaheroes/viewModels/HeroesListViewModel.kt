package com.example.dotaheroes.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.example.domain.models.Hero
import com.example.domain.repositories.HeroRepositoryImpl
import com.example.dotaheroes.helpers.State
import com.example.dotaheroes.helpers.default
import com.example.dotaheroes.helpers.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroesListViewModel() : ViewModel() {
    private val TAG = HeroesListViewModel::class.java.simpleName

    val state: MutableLiveData<State> =
        MutableLiveData<State>().default(initialValue = State.LoadingState())

    init {
        val repository = HeroRepositoryImpl()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val fetchedHeroes = repository.fetchHeroes().await()
                if (fetchedHeroes.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        state.set(newValue = State.NoItemsState())
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        state.set(newValue = State.LoadedState(data = fetchedHeroes))
                        val a = state.set(newValue = State.LoadedState(data = fetchedHeroes))
                        val a1 = a
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "error ${e.localizedMessage}")
                e.printStackTrace()
            }
        }
    }
}

