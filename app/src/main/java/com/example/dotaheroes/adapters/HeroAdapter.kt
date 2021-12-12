package com.example.dotaheroes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>(), AdapterData<Hero> {

    val mHeroList: MutableList<Hero> = LinkedList()
    var itemClicked:(Int) -> Unit = {}

    override fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemClicked = itemClicked,
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

    class ViewHolder(itemView: View,itemClicked:(Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageHero : ImageView = itemView.findViewById(R.id.imageAvatar)
        init{
            imageHero.setOnClickListener{
                itemClicked(adapterPosition)
            }
        }
        fun bind(hero: Hero) {
            Glide.with(itemView.context)
                .load(hero.avatar)
                .fitCenter()
                .into(imageHero)
        }
    }
}