package jp.cordea.roominmemoryarchitecturedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalDataSource @Inject constructor(
    private val mainStateDao: MainStateDao
) {
    companion object {
        private const val PRIMARY_ID = 1L
    }

    val count: LiveData<Int> get() = Transformations.map(mainStateDao.getMainState(PRIMARY_ID)) { it?.count ?: 0 }
    private val current get() = mainStateDao.getCurrentMainState(PRIMARY_ID)

    fun incrementCount() {
        val current = current
        mainStateDao.insertMainState(
            MainState(PRIMARY_ID, (current?.count ?: 0) + 1, current?.liked ?: false)
        )
    }

    fun switchFavorite() {
        val current = current
        mainStateDao.insertMainState(
            MainState(PRIMARY_ID, current?.count ?: 0, (current?.liked ?: false).not())
        )
    }
}
