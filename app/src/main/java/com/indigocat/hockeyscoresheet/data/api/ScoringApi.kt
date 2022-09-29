package com.indigocat.hockeyscoresheet.data.api

import com.indigocat.hockeyscoresheet.domain.model.Game
import retrofit2.http.GET

interface ScoringApi {

    @GET("api/game/{id}")
    suspend fun getGame(id: String): Game?
}