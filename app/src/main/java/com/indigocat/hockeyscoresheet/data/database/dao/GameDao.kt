package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Game

@Dao
interface GameDao {

    @Insert
    fun insert(game: Game)

    @Query("SELECT * FROM game WHERE homeTeam LIKE :teamId OR awayTeam LIKE :teamId")
    fun getGamesForTeam(teamId: Int): List<Game>

    @Query("SELECT * FROM game WHERE dateTime LIKE :date")
    fun getGamesForDate(date: String): List<Game>

    @Query("SELECT * FROM game WHERE id IS :gameId")
    fun getGameById(gameId: String): Game?

}
