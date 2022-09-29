package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.PlayerTeam

@Dao
interface PlayerTeamDao {

    @Insert
    fun insert(item: PlayerTeam)

    @Query("SELECT * FROM playerTeam WHERE teamId IS :teamId")
    fun getPlayersForTeam(teamId: Int): List<PlayerTeam>

}