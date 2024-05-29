package com.project.tathanhson.exampleroomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.tathanhson.exampleroomdatabase.model_db.ItemLiveWallpaper
import com.project.tathanhson.exampleroomdatabase.model_db.ItemWallpaper
import com.project.tathanhson.mediaplayer.model.ItemRingtone

@Dao
interface ItemLiveWallpaperDao {
    @Insert
    suspend fun insert(item: ItemLiveWallpaper)

    @Query("SELECT * FROM ItemLiveWallpaper WHERE id = :id")
    suspend fun getItemById(id: Int): ItemLiveWallpaper?

    @Query("DELETE FROM ItemLiveWallpaper WHERE id = :id")
    suspend fun deleteById(id: Int)
}

@Dao
interface ItemRingtoneDao {
    @Insert
    suspend fun insert(item: ItemRingtone)

    @Query("SELECT * FROM ItemRingtone WHERE link = :link")
    suspend fun getItemByLink(link: String): ItemRingtone?

    @Query("DELETE FROM ItemRingtone WHERE link = :link")
    suspend fun deleteByLink(link: String)
}

@Dao
interface ItemWallpaperDao {
    @Insert
    suspend fun insert(item: ItemWallpaper)

    @Query("SELECT * FROM ItemWallpaper WHERE id = :id")
    suspend fun getItemById(id: Int): ItemWallpaper?

    @Query("DELETE FROM ItemWallpaper WHERE id = :id")
    suspend fun deleteById(id: Int)
}