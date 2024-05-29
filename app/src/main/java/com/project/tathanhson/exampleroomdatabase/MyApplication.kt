package com.project.tathanhson.exampleroomdatabase

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class MyApplication : Application() {
    companion object {
        private var database: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            return database!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).build()
    }
}