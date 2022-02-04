package com.example.fruitmarket.sign_in

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fruitmarket.DataBase.UserDataBase
import com.example.fruitmarket.Fragments.Splash.splash_2_FragmentDirections
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.ListUsers
import com.example.fruitmarket.R
import com.example.fruitmarket.Users
import com.example.fruitmarket.databinding.FragmentSignInBinding
import com.example.fruitmarket.databinding.FragmentSignUpBinding
import com.example.fruitmarket.window_main.Drawer_activity

class Sign_up_Fragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding

    var favoritesList: ArrayList<FruitsData> = ArrayList()

    var ordersList: ArrayList<FruitsData> = ArrayList()

    var log: Boolean = false

    var par: Boolean = false

    var logIn: String = ""

    var parol: String = ""

    var mail: String = ""

    var name: String = ""


    var imAge3 = R.drawable.notes


    var vvseUsers = ListUsers


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)


        binding.registerCreat.setOnClickListener {

            ListUsers.allUsers.add(Users(
                "hoji",
                "hoji",
                imAge3.toString(),
                "hojiakbar_1997@mail.ru",
                "Hojiakbar",
            ))


            logIn = binding.CreatLoginn.text.toString()

            parol = binding.CreatPassword.text.toString()

            mail = binding.CreatMail.text.toString()

            name = binding.CreatName.text.toString()

            var usersF = Users()

            usersF.login = logIn

            usersF.password = parol

            usersF.mail = mail

            usersF.photo = imAge3

            usersF.name = name


//            ListUsers.allUsers.add(Users("hoji",
//                "hoji",
//                "hojiakbar_1997@mail.ru",
//                "Hojiakbar", ))

            ListUsers.allUsers.add(usersF)

            UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().add_New_User(usersF)

            Toast.makeText(requireContext(), "аккаунт создан", Toast.LENGTH_SHORT).show()

            val action = Sign_up_FragmentDirections.actionSignUpFragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)

        }

        binding.creatLogin.setOnClickListener {
            val action = Sign_up_FragmentDirections.actionSignUpFragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)
        }


        return binding.root
    }


}