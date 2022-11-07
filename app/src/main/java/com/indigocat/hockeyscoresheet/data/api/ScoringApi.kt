package com.indigocat.hockeyscoresheet.data.api

import com.indigocat.hockeyscoresheet.data.api.model.Game
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ScoringRepository {

    @GET("api/game/{id}")
    suspend fun getGame(id: String): Game?
}


val scoringService = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://www.dwhl.org")
    .build()
    .create<ScoringRepository>()
