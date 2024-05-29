package com.project.tathanhson.exampleroomdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.tathanhson.exampleroomdatabase.databinding.ActivityMainBinding
import com.project.tathanhson.exampleroomdatabase.model_db.ItemLiveWallpaper
import com.project.tathanhson.exampleroomdatabase.model_db.ItemWallpaper
import com.project.tathanhson.exampleroomdatabase.viewmodel.LiveWallpaperViewModel
import com.project.tathanhson.exampleroomdatabase.viewmodel.RingtoneViewModel
import com.project.tathanhson.exampleroomdatabase.viewmodel.WallpaperViewModel
import com.project.tathanhson.mediaplayer.model.ItemRingtone

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val wallpaperViewModel: WallpaperViewModel by viewModels()
    private val liveWallpaperViewModel: LiveWallpaperViewModel by viewModels()
    private val ringtoneViewModel: RingtoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Wallpaper Buttons
        binding.buttonAddWallpaper.setOnClickListener {
            val wallpaper = ItemWallpaper(
                category_id = 1,
                date_upload = "2023-01-01",
                download = 100,
                favorite = 50,
                id = 1,
                img_large = "large_image_url",
                img_thumb = "thumb_image_url",
                live = 0,
                name = "Sample Wallpaper",
                premium = 0
            )
            wallpaperViewModel.insertWallpaper(wallpaper)
        }

        binding.buttonGetWallpaper.setOnClickListener {
            wallpaperViewModel.getWallpaperById(1).observe(this) { wallpaper ->
                Toast.makeText(this, wallpaper?.name ?: "Wallpaper not found", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.buttonDeleteWallpaper.setOnClickListener {
            wallpaperViewModel.deleteWallpaperById(1)
        }

        // Live Wallpaper Buttons
        binding.buttonAddLiveWallpaper.setOnClickListener {
            val liveWallpaper = ItemLiveWallpaper(
                category_id = 1,
                date_upload = "2023-01-01",
                download = 200,
                favorite = 75,
                id = 1,
                img_large = "large_image_url_live",
                img_thumb = "thumb_image_url_live",
                live = 1,
                name = "Sample Live Wallpaper",
                premium = 1
            )
            liveWallpaperViewModel.insertLiveWallpaper(liveWallpaper)
        }

        binding.buttonGetLiveWallpaper.setOnClickListener {
            liveWallpaperViewModel.getLiveWallpaperById(1).observe(this) { liveWallpaper ->
                Toast.makeText(
                    this,
                    liveWallpaper?.name ?: "Live Wallpaper not found",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.buttonDeleteLiveWallpaper.setOnClickListener {
            liveWallpaperViewModel.deleteLiveWallpaperById(1)
        }

        // Ringtone Buttons
        binding.buttonAddRingtone.setOnClickListener {
            val ringtone = ItemRingtone(
                link = "ringtone_link",
                name = "Sample Ringtone",
                size = "5MB",
                time = "00:30"
            )
            ringtoneViewModel.insertRingtone(ringtone)
        }

        binding.buttonGetRingtone.setOnClickListener {
            ringtoneViewModel.getRingtoneByLink("ringtone_link").observe(this) { ringtone ->
                Toast.makeText(this, ringtone?.name ?: "Ringtone not found", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.buttonDeleteRingtone.setOnClickListener {
            ringtoneViewModel.deleteRingtoneByLink("ringtone_link")
        }
    }
}
