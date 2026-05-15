package com.raithavarta

import android.app.Application
import com.raithavarta.data.local.AppDatabase
import com.raithavarta.data.repository.TipRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import com.raithavarta.util.DataSeeder

class RaithaVartaApp : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy {
        TipRepository(
            database.tipDao(),
            database.categoryDao(),
            database.successStoryDao()
        )
    }

    override fun onCreate() {
        super.onCreate()
        seedDatabase()
    }

    private fun seedDatabase() {
        applicationScope.launch {
            repository.insertCategories(DataSeeder.getCategories())
            repository.insertTips(DataSeeder.getTips())
            repository.insertStories(DataSeeder.getSuccessStories())
        }
    }
}