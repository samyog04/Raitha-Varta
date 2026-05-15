package com.raithavarta.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raithavarta.data.local.dao.CategoryDao
import com.raithavarta.data.local.dao.SuccessStoryDao
import com.raithavarta.data.local.dao.TipDao
import com.raithavarta.data.model.Category
import com.raithavarta.data.model.SuccessStory
import com.raithavarta.data.model.Tip

@Database(
    entities = [Tip::class, Category::class, SuccessStory::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tipDao(): TipDao
    abstract fun categoryDao(): CategoryDao
    abstract fun successStoryDao(): SuccessStoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "raithavarta_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}