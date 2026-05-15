package com.raithavarta.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raithavarta.data.model.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(categories: List<Category>)
}