package com.example.dotaheroes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.dotaheroes.R
import com.example.dotaheroes.databinding.FragmentChooseListBinding
import com.example.dotaheroes.databinding.FragmentHeroInfoBinding


class ChooseListFragment : Fragment() {

    lateinit var binding: FragmentChooseListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseListBinding.inflate(inflater,container,false)
        binding.viewListOfHeroes.setOnClickListener {
            findNavController().navigate(
                R.id.action_chooseListFragment_to_heroListFragment
            )
        }
        binding.viewListOfFavouriteHeroes.setOnClickListener {
            findNavController().navigate(
                R.id.action_chooseListFragment_to_favouriteHeroesFragment
            )
        }
        return binding.root
    }


}
