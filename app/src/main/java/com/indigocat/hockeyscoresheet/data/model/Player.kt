package com.indigocat.hockeyscoresheet.data.model

data class Player(
    val id: String,
    val givenName: String,
    val familyName: String,
    val number: Int = -1,
    val position: String? = null
) {
    companion object {
        fun defaultPlayer(): Player {
            return Player("","", "")
        }
    }
}


