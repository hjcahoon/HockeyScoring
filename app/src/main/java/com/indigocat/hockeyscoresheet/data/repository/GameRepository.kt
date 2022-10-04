package com.indigocat.hockeyscoresheet.data.repository

import com.indigocat.hockeyscoresheet.data.api.ScoringApi
import com.indigocat.hockeyscoresheet.data.database.ScoringDatabase
import com.indigocat.hockeyscoresheet.domain.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameRepository(
    private val scoringApi: ScoringApi,
    private val database: ScoringDatabase
    ) {

    suspend fun getGame(id: String) : Game? {
        var game: Game? = null
        withContext(Dispatchers.IO) {
            val dbGame = database.gameDao().getGameById(id)
            if (dbGame == null) {
                game = scoringApi.getGame(id)
            } else {
                launch {
                    val homeTeam = database.teamDao().getTeam(dbGame.homeTeam)
                }



            }
        }
        return game
    }



}