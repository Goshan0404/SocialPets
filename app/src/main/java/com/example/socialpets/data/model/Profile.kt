package com.example.socialpets.data.model

data class Profile(
    val name: String,
    val age: String,
    val photo: Int,
    val pets: List<Pet>,
    val bio: String
)

