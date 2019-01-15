package jp.cordea.roominmemoryarchitecturedemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "main_state"
)
class MainState(
    @PrimaryKey val id: Long,
    val count: Int,
    val liked: Boolean
)
