package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Goal

@Dao
interface GoalDao {

    @Insert
    fun insert(goal: Goal)

    @Query("SELECT * FROM goal WHERE gameId IS :gameId")
    fun getGoalsForGame(gameId: Int): List<Goal>

    @Query("SELECT * FROM goal WHERE goalScorer IS :playerId")
    fun getGoalsForPlayer(playerId: Int): List<Goal>

    @Query("SELECT * FROM goal WHERE goalScorer IS :playerId OR assist1 IS :playerId OR assist2 IS :playerId")
    fun getPointsForPlayer(playerId: Int): List<Goal>
}