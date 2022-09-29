package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Facility

@Dao
interface FacilityDao {

    @Insert
    fun insert(facility: Facility)

    @Query("SELECT * FROM facility WHERE id like :id")
    fun getFacility(id: Int): Facility
}