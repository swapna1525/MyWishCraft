package com.androidprojects.mywishcraft.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.mywishcraft.R
import com.androidprojects.mywishcraft.model.OccasionsList


class OccasionsListAdapter(
    private val items: List<OccasionsList>,
    private val onItemClick: (OccasionsList) -> Unit
) : RecyclerView.Adapter<OccasionsListAdapter.OccasionViewHolder>() {

    inner class OccasionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val occasionImage: ImageView = itemView.findViewById(R.id.imv_occasion_logo)
        val occasionTitle: TextView = itemView.findViewById(R.id.tv_occasion_name)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OccasionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_occasion, parent, false)
        return OccasionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OccasionViewHolder, position: Int) {
        val item = items[position]
        holder.occasionTitle.text = item.occasionName
        holder.occasionImage.setImageResource(item.occasionLogo)
    }

    override fun getItemCount(): Int = items.size
}
