package com.indigocat.hockeyscoresheet

import android.app.Application
import com.indigocat.hockeyscoresheet.data.database.ScoringDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class ScoringApplication: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ScoringDatabase.getDatabase(this, applicationScope) }
}
