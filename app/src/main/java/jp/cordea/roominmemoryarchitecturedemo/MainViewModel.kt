package jp.cordea.roominmemoryarchitecturedemo

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    fun clicked() = repository.switchFavorite()
}
