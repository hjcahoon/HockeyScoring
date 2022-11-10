package com.indigocat.hockeyscoresheet.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gameRepository: GameRepository
): ViewModel() {


    var currentGames: LiveData<List<Game>> = gameRepository.getNextGames().asLiveData()


    val allPlayers: LiveData<List<Player>> = gameRepository.getAllPlayers().asLiveData()


}
