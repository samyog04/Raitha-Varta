package com.raithavarta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raithavarta.data.model.Tip
import com.raithavarta.databinding.ItemTipCardBinding

class TipPagerAdapter : ListAdapter<Tip, TipPagerAdapter.TipViewHolder>(DiffCallback()) {

    inner class TipViewHolder(private val binding: ItemTipCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: Tip) {
            binding.tvTitle.text = tip.title
            binding.tvDescription.text = tip.description
            binding.tvEmoji.text = when {
                tip.title.contains("Water", ignoreCase = true) -> "💧"
                tip.title.contains("Pest", ignoreCase = true) -> "🐛"
                tip.title.contains("Soil", ignoreCase = true) -> "🌱"
                tip.title.contains("Fertilizer", ignoreCase = true) -> "🧪"
                tip.title.contains("Irrigation", ignoreCase = true) -> "🚿"
                tip.title.contains("Spacing", ignoreCase = true) -> "📏"
                tip.title.contains("Harvest", ignoreCase = true) -> "🌾"
                else -> "🌿"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemTipCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Tip>() {
        override fun areItemsTheSame(oldItem: Tip, newItem: Tip) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Tip, newItem: Tip) = oldItem == newItem
    }
}