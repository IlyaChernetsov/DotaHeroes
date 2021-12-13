package com.example.dotaheroes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Hero
import com.example.dotaheroes.R
import com.example.dotaheroes.business.HeroUi
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>(), AdapterData<HeroUi> {

    val mHeroModelList: MutableList<HeroUi> = LinkedList()
    var itemClicked:(Int) -> Unit = {}

    override fun setData(newHeroModels: List<HeroUi>) {
        mHeroModelList.clear()
        mHeroModelList.addAll(newHeroModels)
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
        holder.bind(heroModel = mHeroModelList[position])
    }

    override fun getItemCount(): Int {
        return mHeroModelList.count()
    }

    class ViewHolder(itemView: View,itemClicked:(Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageHero : ImageView = itemView.findViewById(R.id.imageAvatar)
        init{
            imageHero.setOnClickListener{
                itemClicked(adapterPosition)
            }
        }
        fun bind(heroModel: HeroUi) {
            Glide.with(itemView.context)
                .load(heroModel.avatar)
                .fitCenter()
                .into(imageHero)
        }
    }
}