package com.example.fruitmarket.Fragments.Splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fruitmarket.databinding.FragmentSplash3Binding


class splash_3_Fragment : Fragment() {

    lateinit var binding: FragmentSplash3Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentSplash3Binding.inflate(layoutInflater,container,false)

//        val v: View = inflater.inflate(R.layout.activity_setting, null)


        binding.textView.setOnClickListener {
            val action = splash_3_FragmentDirections.actionSplash3FragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)
        }


        binding.button.setOnClickListener {
            val action =
                splash_3_FragmentDirections.actionSignUpFragmentToSignInFragment()
            Navigation.findNavController(it).navigate(action)

//


        }

        // Inflate the layout for this fragment
        return binding.root
    }


}