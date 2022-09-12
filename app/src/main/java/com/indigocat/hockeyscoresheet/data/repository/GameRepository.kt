package com.indigocat.hockeyscoresheet.data.repository

import com.indigocat.hockeyscoresheet.data.model.Game
import com.indigocat.hockeyscoresheet.network.ScoringApi

class GameRepository(val scoringApi: ScoringApi) {

    suspend fun getGame(id: String) : Game? {
        return scoringApi.getGame(id)
    }
}