package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Penalty

@Dao
interface PenaltyDao {

    @Insert
    fun insert(penalty: Penalty)

    @Query("SELECT * FROM penalty WHERE gameId IS :gameId")
    fun getPenaltiesForGame(gameId: Int): List<Penalty>

    @Query("SELECT * FROM penalty WHERE player is :playerId")
    fun getPenaltiesForPlayer(playerId: Int): List<Penalty>

}
