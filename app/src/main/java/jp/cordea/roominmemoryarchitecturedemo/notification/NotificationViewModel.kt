package jp.cordea.roominmemoryarchitecturedemo.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import jp.cordea.roominmemoryarchitecturedemo.MainRepository
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    val text: LiveData<String> get() = Transformations.map(repository.count) { it.toString() }

    fun clicked() = repository.incrementCount()
}
