package com.project.tathanhson.exampleroomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.tathanhson.exampleroomdatabase.MyApplication
import com.project.tathanhson.exampleroomdatabase.model_db.ItemWallpaper
import kotlinx.coroutines.launch

class WallpaperViewModel : ViewModel() {

    private val wallpaperDao = MyApplication.getDatabase().itemWallpaperDao()
    private val _wallpaper = MutableLiveData<ItemWallpaper?>()

    val wallpaper: LiveData<ItemWallpaper?> get() = _wallpaper

    fun insertWallpaper(item: ItemWallpaper) {
        viewModelScope.launch {
            wallpaperDao.insert(item)
        }
    }

    fun getWallpaperById(id: Int): LiveData<ItemWallpaper?> {
        viewModelScope.launch {
            _wallpaper.postValue(wallpaperDao.getItemById(id))
        }
        return _wallpaper
    }

    fun deleteWallpaperById(id: Int) {
        viewModelScope.launch {
            wallpaperDao.deleteById(id)
        }
    }
}


