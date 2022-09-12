package com.indigocat.hockeyscoresheet.data.model

data class Person(
    val id: String,
    val givenName: String,
    val familyName: String,
    val email: String? = null,
    val phone: String? = null
)
