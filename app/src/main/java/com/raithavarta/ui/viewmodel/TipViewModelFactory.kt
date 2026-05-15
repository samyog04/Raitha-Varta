package com.raithavarta.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raithavarta.data.repository.TipRepository

class TipViewModelFactory(private val repository: TipRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TipViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TipViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}