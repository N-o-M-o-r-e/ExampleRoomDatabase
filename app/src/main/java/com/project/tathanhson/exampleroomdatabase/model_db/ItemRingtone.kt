package com.project.tathanhson.mediaplayer.model

import androidx.room.Entity
import java.io.Serializable

@Entity(primaryKeys = ["link"])
data class ItemRingtone(
    val link: String,
    val name: String,
    val size: String,
    val time: String
) : Serializable