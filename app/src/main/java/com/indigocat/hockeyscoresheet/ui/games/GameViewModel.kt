package com.indigocat.hockeyscoresheet.ui.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import com.indigocat.hockeyscoresheet.data.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    private var _gameId = MutableLiveData<String?>(null)
    private val _gameDetails = MutableLiveData<Game>()
    val gameDetails: LiveData<Game?> = _gameDetails
    val _goals: MutableLiveData<List<Goal>> = MutableLiveData(emptyList())



    fun setGameId(id: String) {
        _gameId.value = id
        getGame(id)
    }

    private fun getGame(gameId: String)  {
        viewModelScope.launch(Dispatchers.IO) {
            _gameDetails.postValue(gameRepository.getGame(gameId))

        }
    }

    val homeRoster = gameDetails.switchMap {
        var players: List<Player>? = null

        it?.homeTeam?.id?.let { teamId ->
            viewModelScope.launch(Dispatchers.IO) {
                players = playerRepository.getPlayersForTeam(teamId)
            }
        }
        MutableLiveData(players)
    }


    val goals = _gameId.switchMap {
        it?.let { gameId ->
            gameRepository.getGoalsForGame(gameId).asLiveData()
        }
    }

    val awayRoster = gameDetails.switchMap {
        var players: List<Player>? = null

        it?.awayTeam?.id?.let { teamId ->
            viewModelScope.launch(Dispatchers.IO) {
                players = playerRepository.getPlayersForTeam(teamId)
            }
        }
        MutableLiveData(players)
    }

}
