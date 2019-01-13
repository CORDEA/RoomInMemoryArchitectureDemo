package jp.cordea.roominmemoryarchitecturedemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MainState::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainStateDao(): MainStateDao
}
