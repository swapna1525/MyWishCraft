package com.androidprojects.mywishcraft.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.mywishcraft.databinding.ItemFestivalBinding
import com.androidprojects.mywishcraft.model.OccasionsList

class FestivalListAdapter(
    private val originalList: List<OccasionsList>,
    private val onItemClick: (OccasionsList) -> Unit
) : RecyclerView.Adapter<FestivalListAdapter.FestivalViewHolder>() {

    private var filteredList: MutableList<OccasionsList> = originalList.toMutableList()

    inner class FestivalViewHolder(val binding: ItemFestivalBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(filteredList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalViewHolder {
        val binding = ItemFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FestivalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FestivalViewHolder, position: Int) {
        val item = filteredList[position]
        holder.binding.tvFestivalName.text = item.occasionName
        holder.binding.imvFestivalLogo.setImageResource(item.occasionLogo)
    }

    override fun getItemCount(): Int = filteredList.size

    // 🔍 Call this from Fragment when search input changes
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(searchText: String) {
        filteredList = if (searchText.isEmpty()) {
            originalList.toMutableList()
        } else {
            originalList.filter {
                it.occasionName.contains(searchText, ignoreCase = true)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }
}
