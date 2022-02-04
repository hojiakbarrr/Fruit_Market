package com.example.fruitmarket.Fragments.Splash

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fruitmarket.databinding.FragmentSignUpBinding
import com.example.fruitmarket.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)




        return binding.root
    }

//    private fun startCountDownTimer(abc: Long) {
//
//        timer = object : CountDownTimer(60000, 1000) {
//            override fun onTick(timeM: Long) {
//                val result = (timeM / 60000).toInt()
////                seekBar?.apply {
////                    progress = result
////
////                }
////
//            }
//
//            override fun onFinish() {
//
//            }
//        }.start()
//
//    }

}