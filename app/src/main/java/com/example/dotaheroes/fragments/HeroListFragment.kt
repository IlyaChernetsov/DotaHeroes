package com.example.dotaheroes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import com.example.dotaheroes.adapters.HeroAdapter
import com.example.dotaheroes.databinding.FragmentHeroListBinding
import com.example.dotaheroes.viewModels.HeroesListViewModel

class HeroListFragment : Fragment(R.layout.fragment_hero_list) {
    lateinit var binding: FragmentHeroListBinding

    private val viewModel: HeroesListViewModel by viewModels()
    private val TAG = HeroListFragment::class.java.simpleName


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroListBinding.inflate(inflater,container,false)
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.recycleHeroList.layoutManager = layoutManager
        val adapter = HeroAdapter()
        binding.recycleHeroList.adapter = adapter
        viewModel.heroes.observe(viewLifecycleOwner, Observer{
            adapter.setData(it)
        })
        return binding.root
    }
}
