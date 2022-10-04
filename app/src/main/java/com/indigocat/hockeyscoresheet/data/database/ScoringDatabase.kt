package com.indigocat.hockeyscoresheet.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigocat.hockeyscoresheet.data.database.dao.FacilityDao
import com.indigocat.hockeyscoresheet.data.database.dao.GameDao
import com.indigocat.hockeyscoresheet.data.database.dao.GoalDao
import com.indigocat.hockeyscoresheet.data.database.dao.PenaltyDao
import com.indigocat.hockeyscoresheet.data.database.dao.PlayerDao
import com.indigocat.hockeyscoresheet.data.database.dao.PlayerTeamDao
import com.indigocat.hockeyscoresheet.data.database.dao.TeamDao
import com.indigocat.hockeyscoresheet.data.database.entities.AssistantCoachTeam
import com.indigocat.hockeyscoresheet.data.database.entities.Facility
import com.indigocat.hockeyscoresheet.data.database.entities.FacilityRinks
import com.indigocat.hockeyscoresheet.data.database.entities.Game
import com.indigocat.hockeyscoresheet.data.database.entities.Goal
import com.indigocat.hockeyscoresheet.data.database.entities.Penalty
import com.indigocat.hockeyscoresheet.data.database.entities.Person
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.data.database.entities.PlayerTeam
import com.indigocat.hockeyscoresheet.data.database.entities.Team
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
