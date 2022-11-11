package com.indigocat.hockeyscoresheet.di

import android.content.Context
import androidx.room.Room
import com.indigocat.hockeyscoresheet.data.api.scoringService
import com.indigocat.hockeyscoresheet.data.database.GameDayDatabase
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import com.indigocat.hockeyscoresheet.data.repository.PlayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameDayModule {

    @Singleton
    @Provides
    fun provideScoringDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        GameDayDatabase::class.java,
        "scoring_database"
    ).createFromAsset("database/ScoringDB.db")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideGameDao(db: GameDayDatabase) =  db.gameDao()

    @Singleton
    @Provides
    fun provideGameRepository(
        db: GameDayDatabase,
    ) = GameRepository(db, scoringService)

    @Singleton
    @Provides
    fun providePlayerRepository(
        db: GameDayDatabase,
    ) = PlayerRepository(db, scoringService)

    @Singleton
    @Provides
    fun provideScoringService() = scoringService
}
