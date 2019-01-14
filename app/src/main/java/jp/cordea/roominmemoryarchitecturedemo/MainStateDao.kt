package jp.cordea.roominmemoryarchitecturedemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MainStateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMainState(mainState: MainState)

    @Query("SELECT * FROM main_state WHERE id = :id")
    fun getMainState(id: Long): LiveData<MainState?>
}
