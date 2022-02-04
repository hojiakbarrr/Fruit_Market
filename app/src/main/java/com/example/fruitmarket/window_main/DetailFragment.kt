package com.example.fruitmarket.window_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.fruitmarket.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    val oldNotes by navArgs<DetailFragmentArgs>()
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)

        binding.cardPhoto.setImageResource(oldNotes.data.image)

        binding.favDescr.setText(oldNotes.data.description)

        binding.favTitle.setText(oldNotes.data.title)

        binding.favNutDesc.setText(oldNotes.data.nutrition_1)

        binding.favPrice.setText(oldNotes.data.per_kg)


        // Inflate the layout for this fragment
        return binding.root
    }

}