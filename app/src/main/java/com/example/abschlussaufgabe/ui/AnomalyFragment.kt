package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.GhostAdapter
import com.example.abschlussaufgabe.databinding.FragmentAnomalyBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel


class AnomalyFragment : Fragment() {

    private lateinit var binding: FragmentAnomalyBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anomaly, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //navigation back to HomeFragment 
        binding.ivBackfromAnomalys.setOnClickListener{
            findNavController().popBackStack()
        }

        //ghost rv
        viewModel.ghosts.observe(viewLifecycleOwner){
               binding.rvAnomalys.adapter = GhostAdapter(requireContext(),it)
           }

    }


}

