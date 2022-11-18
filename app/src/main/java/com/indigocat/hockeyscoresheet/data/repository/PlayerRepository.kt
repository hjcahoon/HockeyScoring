package com.indigocat.hockeyscoresheet.data.repository

import com.indigocat.hockeyscoresheet.data.api.ScoringRepository
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.data.api.scoringService
import com.indigocat.hockeyscoresheet.data.database.GameDayDatabase
import com.indigocat.hockeyscoresheet.data.database.extensions.toDataPlayer
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val database: GameDayDatabase,
    private val scoringApi: ScoringRepository = scoringService
) {

    fun getPlayer(id: String): Player? {
        return database.playerDao().getPlayer(id)?.toDataPlayer()
    }

    suspend fun getPlayersForTeam(id: String): List<Player>? {
        val playerIds = database.playerTeamDao().getPlayersForTeam(id)

        return database.playerDao().getPlayers(playerIds).map { it.toDataPlayer() }
    }
}
