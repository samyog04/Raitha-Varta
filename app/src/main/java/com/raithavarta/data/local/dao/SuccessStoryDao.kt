package com.raithavarta.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raithavarta.data.model.SuccessStory

@Dao
interface SuccessStoryDao {
    @Query("SELECT * FROM success_stories")
    fun getAllStories(): LiveData<List<SuccessStory>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(stories: List<SuccessStory>)
}