package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.GhostAdapter
import com.example.abschlussaufgabe.adapter.ReportGhostAdapter
import com.example.abschlussaufgabe.databinding.FragmentAnomalyBinding
import com.example.abschlussaufgabe.databinding.FragmentPopUpBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class PopUpFragment : Fragment() {
    private lateinit var binding: FragmentPopUpBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pop_up, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //rvReport
        viewModel.ghosts.observe(viewLifecycleOwner){
            binding.rvReportGhost.adapter = ReportGhostAdapter(requireContext(),it)
        }

        val ghostName = arguments?.getString("ghostName")

        if (ghostName == ""){

        }




    }
}