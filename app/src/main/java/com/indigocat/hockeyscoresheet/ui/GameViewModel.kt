package com.indigocat.hockeyscoresheet.ui

import androidx.lifecycle.ViewModel
import com.indigocat.hockeyscoresheet.data.repository.GameRepository

class GameViewModel(gameRepository: GameRepository): ViewModel() {

    private var gameId: Int? = null

    fun setGameId(gameId: Int) {
        this.gameId = gameId
        getGameInfo(gameId)
    }

    private fun getGameInfo(gameId: Int) {

    }
}
