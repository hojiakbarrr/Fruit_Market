package com.example.fruitmarket.favorites

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmarket.DataBase.FruitAdapter
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.R
import com.example.fruitmarket.window_main.Main_screenFragmentDirections
import java.util.*

class Favorites_adapter(val list: MutableList<FruitsData>, val clickListener: NextClickListener) :
    RecyclerView.Adapter<Favorites_adapter.Favorites_Holder>() {

    var rr = R.drawable.next

    inner class Favorites_Holder(item: View) : RecyclerView.ViewHolder(item) {
        var fruitImage_shablon: ImageView = itemView.findViewById(R.id.shablon_fav_foto)
        var title_shablon: TextView = itemView.findViewById(R.id.shablon_fav_title)
        var time: TextView = itemView.findViewById(R.id.shablon_fav_date)
        var next: ImageView = itemView.findViewById(R.id.shablon_fav_next)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Favorites_Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shablon_favorites, parent, false)
        return Favorites_Holder(view)
    }


    override fun onBindViewHolder(holder: Favorites_Holder, position: Int) {
      var curreeentDate = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date())

        holder.itemView.apply {
            holder.fruitImage_shablon.setImageResource(list[position].image)
            holder.title_shablon.text = list[position].title
            holder.time.text = curreeentDate
            holder.next.setImageResource(rr)

            val data = list[position]


            holder.next.setOnClickListener {

                val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(data)
                Navigation.findNavController(it).navigate(action)
            }


            holder.itemView.setOnLongClickListener {
                clickListener.fonNextClick(position)
                true
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface NextClickListener {
        fun fonNextClick(position: Int)

    }

}



