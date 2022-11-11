package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.PlayerAndTeam

@Dao
interface PlayerAndTeamDao {

    @Insert
    fun insert(item: PlayerAndTeam)

    @Query("SELECT playerId FROM playerAndTeam WHERE teamId IS :teamId")
    fun getPlayersForTeam(teamId: String): List<String>

}
