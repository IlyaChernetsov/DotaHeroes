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
import com.example.dotaheroes.business.HeroUi
import com.example.dotaheroes.databinding.FragmentHeroInfoBinding

class HeroInfoFragment : Fragment() {

    lateinit var binding: FragmentHeroInfoBinding


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
        binding.rolesList.text = hero?.roles.toString()
        hero?.heroBackGroundColor?.let { binding.containerView.setBackgroundResource(it) }
        hero?.heroAttrIcon?.let { binding.heroImageAttr.setImageResource(it) }
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

        val ARG_INFO_HERO = "ARG_INFO_HERO"
    }
}
