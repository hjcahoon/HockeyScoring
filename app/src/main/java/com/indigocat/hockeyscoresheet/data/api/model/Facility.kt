package com.indigocat.hockeyscoresheet.data.api.model

data class Facility (
    val id: String,
    val name: String?,
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val rinks: List<String>? = null,
    val description: String? = null
)
