package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Game
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert
    fun insert(game: Game)

    @Query("SELECT * FROM game WHERE homeTeamId LIKE :teamId OR awayTeamId LIKE :teamId")
    fun getGamesForTeam(teamId: Int): List<Game>

    @Query("SELECT * FROM game WHERE dateTime LIKE :date OR dateTime IS NULL")
    fun getGamesForDate(date: String): Flow<List<Game>>

    @Query("SELECT * FROM game ")
    fun getAllGames(): Flow<List<Game>>

    @Query("SELECT * FROM game WHERE id IS :gameId")
    fun getGameById(gameId: String): Game?

}
