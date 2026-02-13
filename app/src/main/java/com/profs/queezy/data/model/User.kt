package com.profs.queezy.data.model

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val rating: Int,
    val countryFlag: Int,
    val image: String
)
