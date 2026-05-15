package com.raithavarta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raithavarta.data.model.SuccessStory
import com.raithavarta.databinding.ItemSuccessStoryBinding

class SuccessStoryAdapter : ListAdapter<SuccessStory, SuccessStoryAdapter.StoryViewHolder>(DiffCallback()) {

    inner class StoryViewHolder(private val binding: ItemSuccessStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: SuccessStory) {
            binding.tvFarmerName.text = story.farmerName
            binding.tvLocation.text = story.location
            binding.tvStory.text = story.story
            binding.tvCrop.text = story.cropName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemSuccessStoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<SuccessStory>() {
        override fun areItemsTheSame(oldItem: SuccessStory, newItem: SuccessStory) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: SuccessStory, newItem: SuccessStory) = oldItem == newItem
    }
}