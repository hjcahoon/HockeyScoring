package com.indigocat.hockeyscoresheet.domain.model

data class Person(
    val id: String,
    val givenName: String,
    val familyName: String,
    val email: String? = null,
    val phone: String? = null
)
