package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.api.model.Position
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player WHERE id IN (:userIds)")
    fun getPlayers(userIds: List<String>): List<Player>

    @Query("SELECT * FROM player")
    fun getAllPlayers(): Flow<List<Player>>

    @Query("SELECT * FROM player WHERE id IS :userId")
    fun getPlayer(userId: String): Player?


    @Query("SELECT * FROM player WHERE position like :position")
    fun getPlayersByPosition(position: Position): List<Player>

    @Insert
    fun insertAll(vararg players: Player)

    @Delete
    fun delete(player: Player)
}
