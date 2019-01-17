package jp.cordea.roominmemoryarchitecturedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    val liked: LiveData<Boolean> get() = repository.liked

    fun clicked() = repository.switchFavorite()
}
