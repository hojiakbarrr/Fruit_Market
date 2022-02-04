package com.example.fruitmarket.favorites

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fruitmarket.DataBase.FruitAdapter
import com.example.fruitmarket.DataBase.UserDataBase
import com.example.fruitmarket.DataModel
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.R
import com.example.fruitmarket.Users
import com.example.fruitmarket.databinding.FragmentFavoritesBinding
import com.example.fruitmarket.databinding.FragmentMainScreenBinding
import com.example.fruitmarket.window_main.DetailFragmentArgs
import java.util.*
import kotlin.collections.ArrayList

class FavoritesFragment : Fragment(), Favorites_adapter.NextClickListener {

    val oldNotes by navArgs<DetailFragmentArgs>()


    lateinit var binding: FragmentFavoritesBinding
    private var adapter: Favorites_adapter? = null
    var fruitList: MutableList<FruitsData> = ArrayList()

    var curreeentDate = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date())


    var nameMessage: String = ""

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        fruitList.clear()

        dataModel.message.observe(activity as LifecycleOwner, {
            nameMessage = it
        })

//        curreeentDate = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date())
        val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())


//        oldNotes.data.currentDate = curreeentDate



        fruitList.add(FruitsData(oldNotes.data.likeImage,
            oldNotes.data.image,
            oldNotes.data.title,
            oldNotes.data.per_kg,
            oldNotes.data.nutrition_1,
            oldNotes.data.description, currentDate = curreeentDate))


//        val user = Users()
//        user.listToJson(fruitList)
//        user.favoritesLis


        for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getAllUser()!!) {
            val user = Users()
            user.listToJson(fruitList)
            if (o.name == nameMessage) {
                o.favoritesLis += user.toString()
                UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().update_User(user)
            }


        }
//        val user = UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getUser()


//        UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getAllUser()

//        for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao()
//            .ge0tAllFruit()!!) {
//
//            fruitList.add(o)
//            adapter?.notifyDataSetChanged()
//
//        }


        adapter = Favorites_adapter(fruitList, this)
        binding.recFavorites?.layoutManager = LinearLayoutManager(requireContext())

        binding.recFavorites?.setHasFixedSize(true)
        binding.recFavorites?.adapter = adapter
        adapter?.notifyDataSetChanged()


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun fonNextClick(position: Int) {
        val builder = AlertDialog.Builder(requireContext())

        with(builder) {
            setTitle("Ты хочешь удалить этот фрукт")
            setPositiveButton("Update") { dialog, which ->

//                val cars = database.getCarDao().getCar(carsList.get(position).id)
//                cars.model = carsName
//                cars.price = carsPrice
//                carsList.set(position,cars)
//                database.getCarDao().updateCar(cars)
                fruitList.removeAt(position)
                adapter?.notifyDataSetChanged()
                Toast.makeText(requireContext(), "Удалено", Toast.LENGTH_SHORT).show()

            }
//            setNegativeButton("Delete"){ dialog, which ->
//                carsList.removeAt(position)
//                val cars = carsList.get(position)
//                database.getCarDao().delete(cars)
//                myAdapter?.notifyDataSetChanged()
//                Toast.makeText(this@MainActivity, " Car is deleted", Toast.LENGTH_SHORT).show()
//            }

            setNeutralButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
//            setView(dialogLayout).show()
        }


    }


}