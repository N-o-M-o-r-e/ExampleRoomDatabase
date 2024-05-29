package com.project.tathanhson.exampleroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.tathanhson.exampleroomdatabase.model_db.ItemLiveWallpaper
import com.project.tathanhson.exampleroomdatabase.model_db.ItemWallpaper
import com.project.tathanhson.mediaplayer.model.ItemRingtone

@Database(entities = [ItemLiveWallpaper::class, ItemRingtone::class, ItemWallpaper::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemLiveWallpaperDao(): ItemLiveWallpaperDao
    abstract fun itemRingtoneDao(): ItemRingtoneDao
    abstract fun itemWallpaperDao(): ItemWallpaperDao
}