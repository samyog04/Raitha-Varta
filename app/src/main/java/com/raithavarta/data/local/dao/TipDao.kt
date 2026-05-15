package com.raithavarta.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raithavarta.data.model.Tip

@Dao
interface TipDao {
    @Query("SELECT * FROM tips")
    fun getAllTips(): LiveData<List<Tip>>

    @Query("SELECT * FROM tips WHERE categoryId = :categoryId")
    fun getTipsByCategory(categoryId: Int): LiveData<List<Tip>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(tips: List<Tip>)

    @Update
    suspend fun updateTip(tip: Tip)
}