package com.indigocat.hockeyscoresheet

import android.app.Application
import com.indigocat.hockeyscoresheet.data.database.GameDayDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScoringApplication: Application() {
    val database by lazy { GameDayDatabase.getDatabase(this) }
}
