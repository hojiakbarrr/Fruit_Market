package com.example.fruitmarket.DataBase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.R
import com.example.fruitmarket.window_main.Main_screenFragmentDirections

class FruitAdapter(val list: MutableList<FruitsData>, val clickListener: IconClickListener) :
    RecyclerView.Adapter<FruitAdapter.FruitsHolder>() {

    var rr : Boolean = false
    inner class FruitsHolder(item: View) : RecyclerView.ViewHolder(item) {
        var fruitImage_shablon: ImageView = itemView.findViewById(R.id.photo)
        var title_shablon: TextView = itemView.findViewById(R.id.title_shablon)
        var kgr: TextView = itemView.findViewById(R.id.kg)
        var like: ImageView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shablon, parent, false)
        return FruitsHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsHolder, position: Int) {


        holder.itemView.apply {
            holder.fruitImage_shablon.setImageResource(list[position].image)
            holder.title_shablon.text = list[position].title
            holder.kgr.text = list[position].per_kg + " Per/kg"
            holder.like.setImageResource(list[position].likeImage)

            val data = list[position]
//            list.clear()
            holder.like.setOnClickListener {
                if(!rr){
                    holder.like.setImageResource(R.drawable.favorite)

                    clickListener.fonlikeClick(position)

                    val action = Main_screenFragmentDirections.actionMainScreenFragmentToFavoritesFragment(data)
                    Navigation.findNavController(it).navigate(action)
                    rr = true
                }else{
                    rr = false
                    holder.like.setImageResource(R.drawable.un_favorite)

                }
            }

            holder.itemView.setOnClickListener {


                val action = Main_screenFragmentDirections.actionMainScreenFragmentToDetailFragment(data)
                Navigation.findNavController(it).navigate(action)

            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface IconClickListener {
        fun fonlikeClick(position: Int)
    }

}




