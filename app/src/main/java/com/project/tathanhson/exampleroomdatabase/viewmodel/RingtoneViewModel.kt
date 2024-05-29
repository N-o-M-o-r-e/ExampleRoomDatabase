package com.project.tathanhson.exampleroomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.tathanhson.exampleroomdatabase.MyApplication
import com.project.tathanhson.mediaplayer.model.ItemRingtone
import kotlinx.coroutines.launch

class RingtoneViewModel : ViewModel() {

    private val ringtoneDao = MyApplication.getDatabase().itemRingtoneDao()
    private val _ringtone = MutableLiveData<ItemRingtone?>()

    val ringtone: LiveData<ItemRingtone?> get() = _ringtone

    fun insertRingtone(item: ItemRingtone) {
        viewModelScope.launch {
            ringtoneDao.insert(item)
        }
    }

    fun getRingtoneByLink(link: String): LiveData<ItemRingtone?> {
        viewModelScope.launch {
            _ringtone.postValue(ringtoneDao.getItemByLink(link))
        }
        return _ringtone
    }

    fun deleteRingtoneByLink(link: String) {
        viewModelScope.launch {
            ringtoneDao.deleteByLink(link)
        }
    }
}
