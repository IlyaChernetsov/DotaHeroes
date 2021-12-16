package com.example.dotaheroes.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.dotaheroes.R
import com.example.dotaheroes.business.HeroUi
import com.example.dotaheroes.databinding.FragmentHeroInfoBinding
import java.util.prefs.AbstractPreferences

class HeroInfoFragment : Fragment() {

    lateinit var binding: FragmentHeroInfoBinding
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroInfoBinding.inflate(inflater, container, false)
        val hero = arguments?.getParcelable<HeroUi>(ARG_INFO_HERO)
        binding.heroName.text = hero?.heroName
        binding.attackType.text = hero?.attackType
        binding.heroAttr.text = hero?.attributes
        binding.rolesList.text = hero?.roles
        hero?.heroBackGroundColor?.let { binding.containerView.setBackgroundResource(it) }
        hero?.heroAttrIcon?.let { binding.heroImageAttr.setImageResource(it) }
        hero?.buttonBackGroundColor?.let { binding.showWinRate.setBackgroundResource(it) }
        preferences = requireContext().getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        hero?.isChosen = preferences.getBoolean(IS_CHOSEN, false)
        if (hero?.isChosen == true) {
            binding.addToFavouriteImage.setImageResource(R.drawable.star_full_painted)
        } else {
            binding.addToFavouriteImage.setImageResource(R.drawable.star_not_painted)
        }

        binding.addToFavouriteImage.setOnClickListener {
            if (hero?.isChosen == false) {
                binding.addToFavouriteImage.setImageResource(R.drawable.star_full_painted)
                hero.isChosen = true
                preferences.edit()
                    .clear()
                    .putBoolean(IS_CHOSEN, hero.isChosen)
                    .apply()

            } else {
                binding.addToFavouriteImage.setImageResource(R.drawable.star_not_painted)
                hero?.isChosen = false
                hero?.isChosen?.let { it ->
                    preferences.edit()
                        .clear()
                        .putBoolean(IS_CHOSEN, it)
                        .apply()
                }
            }
        }
        Glide.with(requireActivity())
            .load(hero?.avatar)
            .fitCenter()
            .into(binding.heroIcon)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hero = arguments?.getParcelable<HeroUi>(ARG_INFO_HERO)
        binding.showWinRate.setOnClickListener {
            findNavController().navigate(
                R.id.action_heroInfoFragment_to_heroWinRate,
                bundleOf(HeroWinRate.ARG_RATE_HERO to hero)
            )
        }
    }

    companion object {
        const val APP_PREFERENCES = "APP_PREFERENCES"
        const val IS_CHOSEN = "IS_CHOSEN"
        val ARG_INFO_HERO = "ARG_INFO_HERO"
    }
}
