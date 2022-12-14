package com.indigocat.hockeyscoresheet.data.api.model

data class Player(
    val id: String,
    val givenName: String,
    val familyName: String,
    val number: Int? = null,
    val position: String? = null
) {
    companion object {
        fun defaultPlayer(): Player {
            return Player("-1","", "")
        }

        fun benchPlayer(): Player {
            return Player("-99","Bench", "")
        }
    }
}

enum class Position {
    GOALIE,
    SKATER,
    FORWARD,
    DEFENCE
}


