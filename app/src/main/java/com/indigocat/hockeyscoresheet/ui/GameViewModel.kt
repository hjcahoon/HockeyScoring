package com.indigocat.hockeyscoresheet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameViewModel @Inject constructor(private val gameRepository: GameRepository) : ViewModel() {

    private var _gameId = MutableLiveData<String?>(null)
    val gameDetails: MutableLiveData<Game?> = MutableLiveData(null)

    fun setGameId(id: String) {
        _gameId.value = id
        getGame(id)
    }

    fun getGame(id: String) {
        viewModelScope.launch {
            gameRepository.getGame(id)
        }

    }


}
