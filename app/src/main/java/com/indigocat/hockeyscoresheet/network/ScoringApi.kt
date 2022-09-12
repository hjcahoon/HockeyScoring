package com.indigocat.hockeyscoresheet.network

import com.indigocat.hockeyscoresheet.data.model.Game
import retrofit2.http.GET

interface ScoringApi {

    @GET("api/game/{id}")
    suspend fun getGame(id: String): Game?
}