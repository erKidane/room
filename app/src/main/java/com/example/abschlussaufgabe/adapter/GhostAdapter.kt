package com.example.abschlussaufgabe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.data.model.Ghost
import com.example.abschlussaufgabe.databinding.ItemListBinding


class GhostAdapter (
    private val context: Context,
    private val dataset: List<Ghost>
    ) : RecyclerView.Adapter<GhostAdapter.ItemViewHolder>() {


    class ItemViewHolder( val binding:ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val ghosts = dataset[position]
        holder.binding.tvGhostName.text = context.resources.getString((ghosts.name))
        holder.binding.tvGhostDes.text = context.resources.getString(ghosts.description)
    }


}