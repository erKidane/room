package com.example.abschlussaufgabe.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Ghost
import com.example.abschlussaufgabe.databinding.ReportItemBinding
import com.example.abschlussaufgabe.ui.PopUpFragment
import com.example.abschlussaufgabe.ui.PopUpFragmentDirections
import com.example.abschlussaufgabe.viewmodel.MainViewModel


class ReportGhostAdapter(
    private val context: Context,
    private val dataset: List<Ghost>,
    private val viewModel: MainViewModel,
    private val navController: NavController

) : RecyclerView.Adapter<ReportGhostAdapter.ItemViewHolder>() {


    class ItemViewHolder(val binding: ReportItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val reportGhosts = dataset[position]




        holder.binding.tvTilte.text = context.resources.getString((reportGhosts.name))
        holder.binding.ivGhostPic.setImageResource(reportGhosts.image)
        holder.binding.tvDescrib.text = context.resources.getString((reportGhosts.description))



        //todo: better a when

        holder.binding.cvGhosts.setOnClickListener {

           viewModel.adapterPostition = reportGhosts.id

            Log.e("adapter","${viewModel.adapterPostition}")
            Log.e("viewModel","${viewModel.aktuelleGhostId}")


            //Log.e("reportGhostAdapter","ghostname == ${ghostName} reportGhostName == ${reportGhosts.name}")
            if (viewModel.adapterPostition == viewModel.aktuelleGhostId) {
/*
                Log.e("blalal",viewModel._score.value!!.score.toString())

                viewModel._score.value!!.score += 1

                //var newScore = 0
                //var outScore = viewModel._score.value!!.score

                //newScore = outScore+1
                Log.e("blalal2",viewModel._score.value!!.score.toString())
                viewModel.updateScore("user1", viewModel._score.value!!.score)

*/
                viewModel.updateScore2(1)





                navController.navigate(R.id.action_popUpFragment_to_rightAnswerFragment)

                //Toast.makeText(context, "${viewModel._score}", Toast.LENGTH_SHORT).show()

            }else{

                navController.navigate(R.id.action_popUpFragment_to_wrongAnswerFragment)
            }
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}