package com.indigocat.hockeyscoresheet.data.repository

import com.indigocat.hockeyscoresheet.data.api.ScoringApi
import com.indigocat.hockeyscoresheet.data.database.ScoringDatabase
import com.indigocat.hockeyscoresheet.domain.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepository(
    private val scoringApi: ScoringApi,
    private val database: ScoringDatabase
    ) {

    suspend fun getGame(id: String) : Game? {
        withContext(Dispatchers.IO) {
            var game = database.gameDao().getGameById(id)
            if (game == null) {
                game = scoringApi.getGame(id)
            }
            return game
        }

    }
}