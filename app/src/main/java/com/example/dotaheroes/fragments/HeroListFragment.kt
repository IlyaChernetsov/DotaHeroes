package com.example.dotaheroes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import com.example.dotaheroes.adapters.HeroAdapter
import com.example.dotaheroes.databinding.FragmentHeroListBinding
import com.example.dotaheroes.helpers.State
import com.example.dotaheroes.viewModels.HeroesListViewModel

class HeroListFragment : Fragment(R.layout.fragment_hero_list) {
    private lateinit var binding: FragmentHeroListBinding

    private val viewModel: HeroesListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroListBinding.inflate(inflater, container, false)
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recycleHeroList.layoutManager = layoutManager
        val adapter = HeroAdapter()
        binding.recycleHeroList.adapter = adapter
        viewModel.state.observe(viewLifecycleOwner,
            { newValue ->
                when (newValue) {
                    is State.LoadedState<*> -> {
                        adapter.setData(newValue.data.map { it as Hero })
                        binding.cpbCarry.visibility = View.GONE
                        binding.txtNoItems.visibility = View.GONE
                    }
                    is State.NoItemsState -> {
                        binding.cpbCarry.visibility = View.GONE
                        binding.txtNoItems.visibility = View.VISIBLE
                    }
                    is State.LoadingState -> {
                        binding.cpbCarry.visibility = View.VISIBLE
                        binding.txtNoItems.visibility = View.GONE
                    }
                    is State.ErrorState -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        return binding.root
    }
}

