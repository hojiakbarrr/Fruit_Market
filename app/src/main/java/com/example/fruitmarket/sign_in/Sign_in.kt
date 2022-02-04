package com.example.fruitmarket.sign_in

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fruitmarket.R
import com.example.fruitmarket.databinding.ActivityMainBinding

class Sign_in : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.Container) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }


    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

}