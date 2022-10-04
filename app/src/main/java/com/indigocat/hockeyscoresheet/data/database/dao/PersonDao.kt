package com.indigocat.hockeyscoresheet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indigocat.hockeyscoresheet.data.database.entities.Person

@Dao
interface PersonDao {

    @Insert
    fun insert(person: Person)

    @Query("SELECT * FROM person WHERE id IS :id")
    fun getPerson(id: Int): Person

    @Query("SELECT * FROM person WHERE id IN (:userIds)")
    fun getPeople(userIds: IntArray): List<Person>
}
