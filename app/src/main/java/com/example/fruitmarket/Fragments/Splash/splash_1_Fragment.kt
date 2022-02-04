package com.example.fruitmarket.Fragments.Splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fruitmarket.databinding.FragmentSplash1Binding

class splash_1_Fragment : Fragment() {
    lateinit var binding: FragmentSplash1Binding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSplash1Binding.inflate(layoutInflater,container,false)

        binding.skip1.setOnClickListener {





            val action = splash_1_FragmentDirections.actionSplash1FragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)
        }


        binding.next.setOnClickListener {
            val action = splash_1_FragmentDirections.actionSplash1FragmentToSplash2Fragment()
            Navigation.findNavController(it).navigate(action)
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}