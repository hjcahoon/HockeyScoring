package com.indigocat.hockeyscoresheet

import android.app.Application
import com.indigocat.hockeyscoresheet.data.database.ScoringDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScoringApplication: Application() {
    val database by lazy { ScoringDatabase.getDatabase(this) }
}
