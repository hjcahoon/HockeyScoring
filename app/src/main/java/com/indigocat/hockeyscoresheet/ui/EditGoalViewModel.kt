package com.indigocat.hockeyscoresheet.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.PointType
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import kotlinx.coroutines.launch

class EditGoalViewModel(private val gameRepo: GameRepository) : ViewModel() {

    private var gameId: String? = null
    private var _game = MutableLiveData<Game?>(null)
    val game: LiveData<Game?> = _game

//    fun setGameId(id: String) {
//        gameId = id
//        getGame(id)
//    }

//    private fun getGame(id: String) {
//        viewModelScope.launch {
//            _game.postValue(gameRepo.getGame(id))
//        }
//    }

    fun onPlayerSelected(playerId: String, pointType: PointType) {
        viewModelScope.launch {
            //gameRepo.addPoint(goalId, pointType, playerId)
        }
    }
}
