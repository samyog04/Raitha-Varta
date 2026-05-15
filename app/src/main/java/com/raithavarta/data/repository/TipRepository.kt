package com.raithavarta.data.repository

import androidx.lifecycle.LiveData
import com.raithavarta.data.local.dao.CategoryDao
import com.raithavarta.data.local.dao.SuccessStoryDao
import com.raithavarta.data.local.dao.TipDao
import com.raithavarta.data.model.Category
import com.raithavarta.data.model.SuccessStory
import com.raithavarta.data.model.Tip

class TipRepository(
    private val tipDao: TipDao,
    private val categoryDao: CategoryDao,
    private val successStoryDao: SuccessStoryDao
) {
    // Tips
    val allTips: LiveData<List<Tip>> = tipDao.getAllTips()

    fun getTipsByCategory(categoryId: Int): LiveData<List<Tip>> {
        return tipDao.getTipsByCategory(categoryId)
    }

    suspend fun insertTips(tips: List<Tip>) {
        tipDao.insertAll(tips)
    }

    suspend fun updateTip(tip: Tip) {
        tipDao.updateTip(tip)
    }

    // Categories
    val allCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    suspend fun insertCategories(categories: List<Category>) {
        categoryDao.insertAll(categories)
    }

    // Success Stories
    val allStories: LiveData<List<SuccessStory>> = successStoryDao.getAllStories()

    suspend fun insertStories(stories: List<SuccessStory>) {
        successStoryDao.insertAll(stories)
    }
}