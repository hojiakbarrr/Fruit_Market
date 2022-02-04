package com.example.fruitmarket.sign_in

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.fruitmarket.*
import com.example.fruitmarket.DataBase.UserDataBase
import com.example.fruitmarket.DataBase.UserssDao
import com.example.fruitmarket.ListUsers.Companion.allUsers
import com.example.fruitmarket.databinding.FragmentSignInBinding
import com.example.fruitmarket.window_main.Drawer_activity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Sign_in_Fragment : Fragment() {

    lateinit var binding: FragmentSignInBinding

    var favoritesList: ArrayList<FruitsData> = ArrayList()

    var ordersList: ArrayList<FruitsData> = ArrayList()

    var log: Boolean = false
    var par: Boolean = false

//    var logIn: String = ""
//
//    var parol: String = ""

    var imAge3 = R.drawable.notes


    var vvseUsers = ListUsers

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

//


        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)

        binding.register.setOnClickListener {
            val action =
                Sign_in_FragmentDirections.actionSignInFragmentToSignUpFragment()
            Navigation.findNavController(it).navigate(action)
        }


//        var favoritesList: MutableList<FruitsData> = ArrayList()


//        var ordersList: MutableList<FruitsData> = ArrayList()

        binding.editLogin.doOnTextChanged { text, start, before, count ->
            if (text!!.length < 4) {
                binding.laylogin.error = "No more"
            } else if (text.length > 4) {
                binding.editLogin.error = null
            }
        }


        var usersFavorites = Users()

        usersFavorites.listToJson(favoritesList)
//        usersFavorites.JsonToList(usersFavorites.listToJson(favoritesList))

        binding.enter.setOnClickListener {
            val allUsers1 = vvseUsers.allUsers
//            UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().add_New_User(usersF)
            var logIn = binding.editLogin.text.toString()
            var parol = binding.editPassword.text.toString()

            for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getAllUser()!!) {
                if (o.login == logIn && o.password == parol) {
                    log = true
                    dataModel.message.value = o.name
                    Toast.makeText(requireContext(), "Вы в главном меню", Toast.LENGTH_SHORT).show()
                    var intent: Intent? = Intent(context, Drawer_activity::class.java)
                    startActivity(intent)
                    par = true
                } else if (!log) {
                    par = true
                    Toast.makeText(requireContext(), "Такого аккаунiта нет", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            if (!par) {
                Toast.makeText(requireContext(), "Такого аккаунiта нет", Toast.LENGTH_SHORT).show()
            } else {
//                Toast.makeText(requireContext(), "Такого аккаунiта нет", Toast.LENGTH_SHORT).show()
            }


//            if (!log){
//                log = true
//            }

        }


//        ListUsers.allUsers.add(Users("hoji",
//            "hoji",
//            imAge3,
//            "hojiakbar_1997@mail.ru",
//            "Hojiakbar",
//            favoritesList,
//            ordersList))


//        UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().add_New_User()


        //*/*/*/база данных
        ///<--- 1. login <String>
        ///<--- 2. password <String>
        ///<--- 3. photo <Int>
        ///<--- 4. mail.ru <String>
        ///<--- 5. name <String>


        ///<--- 6. favorites <FruitData>
        ///<--- 7. orders <FruitData>


        ///<--- 7. статичный Multable List <Users>


        ///<--- Dao>
//        @Dao
//        interface CarDao {
//
//            @Insert
//            fun add_New_User(user : User)
//
//            @Update
//            fun update_User(user : User)
//
//            @Delete
//            fun delete_User (user : User)
//
//            @Query("select * from car_database")
//            fun getAllUser(): MutableList<User>?
//
//            @Query("select * from car_database where (userId) id ==:carId")
//            fun getUser(carId : String) : User
//
//        }
        ///<--- Dao>


        ///<--- User_base>

//        @Database (entities = [DetailsMeal :: class], version = 1)
//        abstract class Meal_Base: RoomDatabase (){
//
//            abstract fun getMealDao() : MealDao
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



    }
}