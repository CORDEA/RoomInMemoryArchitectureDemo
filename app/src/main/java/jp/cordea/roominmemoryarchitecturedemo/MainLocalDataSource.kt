package jp.cordea.roominmemoryarchitecturedemo

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

    val count get() = Transformations.map(mainStateDao.getMainState(PRIMARY_ID)) { it?.count ?: 0 }

    fun incrementCount() {
        val current = mainStateDao.getCurrentMainState(PRIMARY_ID)
        mainStateDao.insertMainState(MainState(PRIMARY_ID, (current?.count ?: 0) + 1))
    }
}
