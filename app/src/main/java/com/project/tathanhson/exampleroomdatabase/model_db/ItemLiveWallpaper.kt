package com.project.tathanhson.exampleroomdatabase.model_db

import androidx.room.Entity
import java.io.Serializable

@Entity(primaryKeys = ["id"])
data class ItemLiveWallpaper(
    val category_id: Int,
    val date_upload: String,
    val download: Int,
    val favorite: Int,
    val id: Int,
    val img_large: String,
    val img_thumb: String,
    val live: Int,
    val name: String,
    val premium: Int
) :Serializable