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
import com.example.abschlussaufgabe.databinding.FragmentRightAnswerBinding
import com.example.abschlussaufgabe.databinding.FragmentRightBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel


class RightAnswerFragment : Fragment() {

    class RightFragment : Fragment() {
        private lateinit var binding: FragmentRightAnswerBinding

        private val viewModel: MainViewModel by activityViewModels()


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_right_answer, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


        }
    }
}