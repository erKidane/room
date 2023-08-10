package com.example.abschlussaufgabe.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Ghost
import com.example.abschlussaufgabe.databinding.FragmentFrontBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FrontFragment : Fragment() {


    private lateinit var binding: FragmentFrontBinding

    private val viewModel: MainViewModel by activityViewModels()

    private var ghostsName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ghostsName
        arguments?.let {
            ghostsName = it.getString("Mimic")
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_front, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // spwanTime
        val delayMillis = (400..800).random()

        //spawning ghosts fun
        fun spawnGhost(image: Drawable) {
            binding.ivFirstClone.visibility = View.VISIBLE
            binding.ivFirstClone.setImageDrawable(image)
        }


        //spawn the ghost with randomly timer
        viewModel.viewModelScope.launch(Dispatchers.Main) {
            delay(delayMillis.toLong())
            spawnGhost(binding.ivFirstClone.drawable)
        }


        //to report the Ghosts
        binding.btnReport.setOnClickListener {

            findNavController().navigate(R.id.action_frontFragment_to_popUpFragment)


        }


        //----------------NAVIGATION----------------

        //navigation to the topFragment
        binding.ivTop.setOnClickListener {
            findNavController().navigate(R.id.action_frontFragment_to_topFragment)
        }

        //navigation to the downFragment
        binding.ivDown.setOnClickListener {
            findNavController().navigate(R.id.action_frontFragment_to_downFragment)
        }

        //navigation to the rightFragment
        binding.ivRight.setOnClickListener {
            findNavController().navigate(R.id.action_frontFragment_to_rightFragment)
        }

        //navigation to the leftFragment
        binding.ivLeft.setOnClickListener {
            findNavController().navigate(R.id.action_frontFragment_to_leftFragment)
        }

    }

}