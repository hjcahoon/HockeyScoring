package com.indigocat.hockeyscoresheet.data.repository

import com.indigocat.hockeyscoresheet.data.api.ScoringRepository
import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.data.api.scoringService
import com.indigocat.hockeyscoresheet.data.database.GameDayDatabase
import com.indigocat.hockeyscoresheet.ui.extensions.getTodayWithTimeString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val database: GameDayDatabase,
    private val scoringApi: ScoringRepository = scoringService
) {


    fun getAllPlayers() = database.playerDao().getAllPlayers()

    fun getDBTeams() = database.teamDao().getAllTeams()

    fun getDBGames() = database.gameDao().getAllGames()


    suspend fun getGame(id: String): Game? {
        return withContext(Dispatchers.IO) {
            val dbGame = database.gameDao().getGameById(id)
            if (dbGame == null) {
                scoringApi.getGame(id)
            } else {
                fillInGameDetails(dbGame)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getNextGames(): Flow<List<Game>> {
        val games = database.gameDao().getAllGames()
            .mapLatest {
                it.mapNotNull { game ->
                    fillInGameDetails(game)
                }
            }

        return games
    }

    private suspend fun fillInGameDetails(game: com.indigocat.hockeyscoresheet.data.database.entities.Game): Game? {
        val homeTeam = getTeamDetails(game.homeTeamId)
        val awayTeam = getTeamDetails(game.awayTeamId)
        if (homeTeam == null || awayTeam == null) return null
        return Game(
            game.id,
            homeTeam,
            awayTeam,
            Facility(game.id, "", "", "", "", ""),
            "",
            game.dateTime ?: getTodayWithTimeString(),
            game.homeScore,
            game.awayScore
        )
    }

    private suspend fun getTeamDetails(teamId: String): Team? {
        return withContext(Dispatchers.IO) {

            val dbTeam = database.teamDao().getTeam(teamId)
            val nameSplit = dbTeam.headCoach?.split(" ")
            val headCoach = Person(
                teamId,
                givenName = nameSplit?.get(0) ?: " ",
                familyName = nameSplit?.get(1) ?: ""
            )
            Team(
                teamId,
                dbTeam.name,
                dbTeam.nickname,
                headCoach,
                dbTeam.venue,
                dbTeam.logoUrl,
                dbTeam.wins,
                dbTeam.losses
            )
        }
    }

//    @OptIn(ExperimentalCoroutinesApi::class)
//    private fun getGoalsForGame(gameId: String): Flow<List<Goal>> {
//        return database.goalDao().getGoalsForGame(gameId).mapLatest {
//            it.map { goal ->
//                convertDBGoalToDataGoal(goal)
//            }
//        }
//    }

//    private fun convertDBGoalToDataGoal(goal: com.indigocat.hockeyscoresheet.data.database.entities.Goal): Goal {
//        return Goal(
//            goal.id,
//            goal.gameId,
//            goal.period,
//            goal.time,
//            getPlayer(goal.goalScorer) ?: Player.defaultPlayer(),
//            goal.assist1?.let { getPlayer(it) },
//            goal.assist2?.let { getPlayer(it) },
//            goal.apposingGoalie?.let { getPlayer(it) },
//            PlayType.EvenStrength
//        )
//    }

//    private fun getPenaltiesForGame(gameId: String): List<Penalty> {
//        return database.penaltyDao().getPenaltiesForGame(gameId).map {
//            convertPenaltyDBToData(it)
//        }
//    }

//    private fun convertPenaltyDBToData(penalty: com.indigocat.hockeyscoresheet.data.database.entities.Penalty): Penalty {
//        return Penalty(
//            penalty.id,
//            penalty.gameId,
//            penalty.period,
//            penalty.time,
//            getPlayer(penalty.player) ?: Player.defaultPlayer(),
//            PenaltyType.Minor ,
//            Infraction.valueOf(penalty.infraction)
//
//        )
//    }


}
