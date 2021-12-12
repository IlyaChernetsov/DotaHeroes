package com.example.dotaheroes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import com.example.dotaheroes.databinding.FragmentHeroInfoBinding

class HeroInfoFragment : Fragment() {

    lateinit var binding: FragmentHeroInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroInfoBinding.inflate(inflater, container, false)
        val hero = arguments?.getParcelable<Hero>(ARG_INFO_HERO)
        binding.heroName.text = hero?.heroName
        binding.attackType.text = hero?.attackType
        binding.heroAttr.text = heroAttr(hero)
        binding.rolesList.text = hero?.roles.toString()
        binding.heroImageAttr.setImageResource(heroAttrIcon(hero))
        Glide.with(requireActivity())
            .load(hero?.avatar)
            .fitCenter()
            .into(binding.heroIcon)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hero = arguments?.getParcelable<Hero>(ARG_INFO_HERO)
        binding.showWinRate.setOnClickListener {
            findNavController().navigate(
                R.id.action_heroInfoFragment_to_heroWinRate,
                bundleOf(HeroWinRate.ARG_RATE_HERO to hero)
            )
        }
    }

    fun heroAttr(hero: Hero?): String {
        return when (hero?.attributes) {
            "str" -> "Strength"
            "agi" -> "Agility"
            "int" -> "Intellect"
            else -> "Not Founded"
        }
    }

    fun heroAttrIcon(hero: Hero?): Int {
        return return when (hero?.attributes) {
            "str" -> R.drawable.strength
            "agi" -> R.drawable.agility
            "int" -> R.drawable.intelect
            else -> R.drawable.ic_default_user
        }
    }

    companion object {

        val ARG_INFO_HERO = "ARG_INFO_HERO"
    }
}
