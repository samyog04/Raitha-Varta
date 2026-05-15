package com.raithavarta.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.raithavarta.data.model.SuccessStory
import com.raithavarta.data.model.Tip
import com.raithavarta.data.repository.TipRepository
import com.raithavarta.data.model.Category

class TipViewModel(private val repository: TipRepository) : ViewModel() {

    val allTips: LiveData<List<Tip>> = repository.allTips
    val allCategories: LiveData<List<Category>> = repository.allCategories
    val allStories: LiveData<List<SuccessStory>> = repository.allStories

    private val selectedCategoryId = MutableLiveData<Int?>()

    val filteredTips: LiveData<List<Tip>> = selectedCategoryId.switchMap { categoryId ->
        if (categoryId == null) repository.allTips
        else repository.getTipsByCategory(categoryId)
    }

    fun filterTips(categoryId: Int?) {
        selectedCategoryId.value = categoryId
    }
}