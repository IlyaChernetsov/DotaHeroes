package com.example.dotaheroes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>(), AdapterData<Hero> {

    private val mHeroList: MutableList<Hero> = LinkedList()

    fun test(newHeroes: List<Hero>){
        mHeroList.clear()
    }

    override fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_hero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hero = mHeroList[position])
    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtHeroTitle: TextView = itemView.findViewById(R.id.txtHeroTitle)
        private val txtHeroAttackType: TextView = itemView.findViewById(R.id.txtHeroAttackType)
        fun bind(hero: Hero) {
            txtHeroTitle.text = hero.heroName
            txtHeroAttackType.text = hero.attackType
        }

    }


}