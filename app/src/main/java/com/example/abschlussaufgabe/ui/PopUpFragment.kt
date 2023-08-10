package com.example.abschlussaufgabe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.ReportGhostAdapter
import com.example.abschlussaufgabe.databinding.FragmentPopUpBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel


class PopUpFragment : Fragment() {
    private lateinit var binding: FragmentPopUpBinding

    private val viewModel: MainViewModel by activityViewModels()

    private var ghostsName: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ghostsName
        arguments?.let {
            ghostsName = it.getInt("ghostName")
        }


    }


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
            binding.rvReportGhost.adapter = ReportGhostAdapter(requireContext(),it,viewModel,ghostsName!!)
        }


        if (ghostsName == R.drawable.bild3){

            viewModel._score

        }




    }
}