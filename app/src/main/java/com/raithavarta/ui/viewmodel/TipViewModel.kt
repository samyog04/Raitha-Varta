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

    private val selectedCategoryId = MutableLiveData<Int?>(null)  // ← add null here
    private val searchQuery = MutableLiveData<String>("")

    val filteredTips: LiveData<List<Tip>> = selectedCategoryId.switchMap { categoryId ->
        if (categoryId == null) repository.allTips
        else repository.getTipsByCategory(categoryId)
    }

    fun filterTips(categoryId: Int?) {
        selectedCategoryId.value = categoryId
        searchQuery.value = ""
    }

    fun searchTips(query: String) {
        searchQuery.value = query
        if (query.isEmpty()) {
            selectedCategoryId.value = selectedCategoryId.value
        } else {
            _searchResults.value = allTips.value?.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.description.contains(query, ignoreCase = true)
            } ?: emptyList()
        }
    }
    private val _searchResults = MutableLiveData<List<Tip>>()
    val searchResults: LiveData<List<Tip>> = _searchResults
}