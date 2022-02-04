package com.example.fruitmarket.Fragments.Splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fruitmarket.databinding.FragmentSplash2Binding


class splash_2_Fragment : Fragment() {
    lateinit var binding: FragmentSplash2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSplash2Binding.inflate(layoutInflater,container,false)

        binding.skip2.setOnClickListener {
            val action = splash_2_FragmentDirections.actionSplash2FragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)
        }


        binding.next1.setOnClickListener {
            val action =
                splash_2_FragmentDirections.actionSplash2FragmentToSplash3Fragment()
            Navigation.findNavController(it).navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}