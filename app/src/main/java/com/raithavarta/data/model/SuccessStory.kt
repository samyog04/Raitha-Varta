package com.raithavarta.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "success_stories")
data class SuccessStory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val farmerName: String,
    val location: String,
    val story: String,
    val storyKannada: String,
    val cropName: String,
    val imageUrl: String = ""
)