package com.indigocat.hockeyscoresheet.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigocat.hockeyscoresheet.data.database.dao.*
import com.indigocat.hockeyscoresheet.data.database.entities.*
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [Player::class, AssistantCoachTeam::class, Facility::class,
    FacilityRinks::class, Game::class, Goal::class, Penalty::class, Person::class,
    PlayerTeam::class, Team::class],
    version = 1)
abstract class ScoringDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun facilityDao(): FacilityDao
    abstract fun gameDao(): GameDao
    abstract fun goalDao(): GoalDao
    abstract fun penaltyDao(): PenaltyDao
    abstract fun playerTeamDao(): PlayerTeamDao
    abstract fun teamDao(): TeamDao

    companion object {
        @Volatile
        private var INSTANCE: ScoringDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ScoringDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoringDatabase::class.java,
                    "scoring_database"
                ).createFromAsset("database/scoring.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


}