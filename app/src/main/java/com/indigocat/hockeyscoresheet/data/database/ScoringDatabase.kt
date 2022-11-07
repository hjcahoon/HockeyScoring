package com.indigocat.hockeyscoresheet.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigocat.hockeyscoresheet.data.database.dao.GameDao
import com.indigocat.hockeyscoresheet.data.database.dao.PlayerAndTeamDao
import com.indigocat.hockeyscoresheet.data.database.dao.PlayerDao
import com.indigocat.hockeyscoresheet.data.database.dao.TeamDao
import com.indigocat.hockeyscoresheet.data.database.entities.Game
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.data.database.entities.PlayerAndTeam
import com.indigocat.hockeyscoresheet.data.database.entities.Team

@Database(
    entities = [
        Player::class, Game::class, Team::class,  PlayerAndTeam::class,
         //, Goal::class, Penalty::class //, Person::class,
        //Facility::class,  FacilityRinks::class
    ],
    version = 1)
abstract class ScoringDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun gameDao(): GameDao
    abstract fun playerTeamDao(): PlayerAndTeamDao
    abstract fun teamDao(): TeamDao
    // abstract fun goalDao(): GoalDao
    // abstract fun penaltyDao(): PenaltyDao
    // abstract fun facilityDao(): FacilityDao

    companion object {
        @Volatile
        private var INSTANCE: ScoringDatabase? = null

        fun getDatabase(
            context: Context
        ): ScoringDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoringDatabase::class.java,
                    "scoring_database"
                ).createFromAsset("database/ScoringDB.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


}
