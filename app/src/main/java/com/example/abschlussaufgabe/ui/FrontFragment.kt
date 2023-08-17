package com.example.abschlussaufgabe.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.databinding.FragmentFrontBinding
import com.example.abschlussaufgabe.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FrontFragment : Fragment() {


    private lateinit var binding: FragmentFrontBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_front, container, false)
        return binding.root
    }

    //spawning Mimic ghost
    fun spawnMimic() {
        binding.ivFirstClone.visibility = View.VISIBLE
        //binding.ivFirstClone.setImageDrawable(image)
    }

    //spawning Shadow ghost
    fun spawnShadow() {
        binding.ivFirstShadow.visibility = View.VISIBLE
        //binding.ivFirstShadow.setImageDrawable(image)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //spwanTimer
        val delayMillis = (400..800).random()

        //initialize Ghosts
        val shadow = viewModel.ghosts.value!![1]
        binding.ivFirstShadow.setImageResource(shadow.image)


        val mimic = viewModel.ghosts.value!![0]
        binding.ivFirst.setImageResource(mimic.image)


        val listOfGhosts = listOf(shadow, mimic)
        var randomGhost = listOfGhosts.random()


        //spawn the ghost with randomlytimer
        viewModel.viewModelScope.launch(Dispatchers.Main) {
            delay(delayMillis.toLong())
            spawnShadow()
            spawnMimic()


        }


        //to report the Ghosts
        binding.btnReport.setOnClickListener {

            findNavController().navigate(
                FrontFragmentDirections.actionFrontFragmentToPopUpFragment(
                    randomGhost.name
                )
            )


        }

        //score
        binding.tvScore.text = viewModel.score.value.toString()


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