package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.domain.model.Position

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player WHERE uid IN (:userIds)")
    fun getPlayers(userIds: IntArray): List<Player>

    @Query("SELECT * FROM player WHERE position like :position")
    fun getPlayersByPosition(position: Position): List<Player>

    @Insert
    fun insertAll(vararg players: Player)

    @Delete
    fun delete(player: Player)
}
