package jp.cordea.roominmemoryarchitecturedemo

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val dataSource: MainLocalDataSource
) {
    val count get() = dataSource.count

    fun incrementCount() =
        Completable.fromCallable { dataSource.incrementCount() }.subscribeOn(Schedulers.io())
}
