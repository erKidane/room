package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentRightBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel
import com.example.abschlussaufgabe.viewmodel.MealViewModel


class RightFragment : Fragment() {
    private lateinit var binding: FragmentRightBinding

    private val viewModel: MainViewModel by activityViewModels()
    private val viewModelMeal: MealViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_right, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //navigation to the topFragment
        binding.ivLeft.setOnClickListener {
            findNavController().popBackStack()
        }






        viewModelMeal.randomMeal.observe(viewLifecycleOwner) {


                binding.ivMeal.load(it.image)


        }


    }
}