package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Team

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(team: Team)

    @Query("SELECT * FROM team WHERE id is :id")
    fun getTeam(id: String): Team
}
