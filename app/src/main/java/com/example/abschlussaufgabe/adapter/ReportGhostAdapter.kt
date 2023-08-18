package com.example.abschlussaufgabe.adapter

import android.content.Context
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
    private val ghostName: Int,
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

        holder.binding.cvGhosts.setOnClickListener {
            if (reportGhosts.name == ghostName) {

                viewModel._score.value = viewModel._score.value?.plus(1)
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