package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentHomeBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //navigation to the instructionFragment

        binding.btnStart.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_instructionsFragment)
            viewModel.insertScore(viewModel.scoreFill)

        }

        //navigation to the optionFragment

        binding.btnOption.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_optionFragment)
        }

        //navigation to the anomalyFragment

        binding.btnAnomalys.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_anomalyFragment)
        }


    }



}