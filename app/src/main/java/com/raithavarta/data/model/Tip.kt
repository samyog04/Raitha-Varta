package com.raithavarta.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips")
data class Tip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val categoryId: Int,
    val title: String,
    val titleKannada: String,
    val description: String,
    val descriptionKannada: String,
    val imageUrl: String = "",
    val isFavorite: Boolean = false
)