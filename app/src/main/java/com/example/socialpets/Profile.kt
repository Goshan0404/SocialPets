package com.example.socialpets

data class Profile(
    val name: String,
    val photo: Int,
    val pets: List<Pet>,
    val bio: String
)

