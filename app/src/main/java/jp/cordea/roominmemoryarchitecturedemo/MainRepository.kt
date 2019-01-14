package jp.cordea.roominmemoryarchitecturedemo

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val dataSource: MainLocalDataSource
) {
    val count get() = dataSource.count

    fun updateCount(count: Int) {
        dataSource.updateCount(count)
    }
}
