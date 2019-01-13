package jp.cordea.roominmemoryarchitecturedemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MainStateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMainState(mainState: MainState)
}
