package com.indigocat.hockeyscoresheet.data.api.model

data class Person(
    val id: String,
    val givenName: String,
    val familyName: String,
    val email: String? = null,
    val phone: String? = null
)
