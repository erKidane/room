package com.example.abschlussaufgabe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Ghost
import com.example.abschlussaufgabe.databinding.ReportItemBinding

class ReportGhostAdapter(
    private val context: Context,
    private val dataset: List<Ghost>
): RecyclerView.Adapter<ReportGhostAdapter.ItemViewHolder>() {

    class ItemViewHolder( val binding: ReportItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val reportGhosts = dataset[position]

        holder.binding.tvTilte.text = context.resources.getString((reportGhosts.name))
        holder.binding.ivGhostPic.setImageResource(reportGhosts.image)
        holder.binding.tvDescrib.text = context.resources.getString((reportGhosts.description))

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}