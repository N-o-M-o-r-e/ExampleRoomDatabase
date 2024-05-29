package com.project.tathanhson.exampleroomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.tathanhson.exampleroomdatabase.MyApplication
import com.project.tathanhson.exampleroomdatabase.model_db.ItemLiveWallpaper
import kotlinx.coroutines.launch

class LiveWallpaperViewModel : ViewModel() {

    private val liveWallpaperDao = MyApplication.getDatabase().itemLiveWallpaperDao()
    private val _liveWallpaper = MutableLiveData<ItemLiveWallpaper?>()

    val liveWallpaper: LiveData<ItemLiveWallpaper?> get() = _liveWallpaper

    fun insertLiveWallpaper(item: ItemLiveWallpaper) {
        viewModelScope.launch {
            liveWallpaperDao.insert(item)
        }
    }

    fun getLiveWallpaperById(id: Int): LiveData<ItemLiveWallpaper?> {
        viewModelScope.launch {
            _liveWallpaper.postValue(liveWallpaperDao.getItemById(id))
        }
        return _liveWallpaper
    }

    fun deleteLiveWallpaperById(id: Int) {
        viewModelScope.launch {
            liveWallpaperDao.deleteById(id)
        }
    }
}

