package com.indigocat.hockeyscoresheet.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.data.repository.GameRepository

class MainViewModel(
    private val gameRepository: GameRepository
): ViewModel() {


    var currentGames: LiveData<List<Game>> = gameRepository.getNextGames().asLiveData()


    val allPlayers: LiveData<List<Player>> = gameRepository.getAllPlayers().asLiveData()


}
