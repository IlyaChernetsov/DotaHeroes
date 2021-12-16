package com.example.dotaheroes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dotaheroes.business.HeroUi
import com.example.dotaheroes.databinding.FragmentHeroWinRateBinding


class HeroWinRate : Fragment() {

    lateinit var binding: FragmentHeroWinRateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroWinRateBinding.inflate(inflater, container, false)
        val hero = arguments?.getParcelable<HeroUi>(ARG_RATE_HERO)
        return binding.root
    }

    companion object {
        val ARG_RATE_HERO = "ARG_RATE_HERO"
    }
}