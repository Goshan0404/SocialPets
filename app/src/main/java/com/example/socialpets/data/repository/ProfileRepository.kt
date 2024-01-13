package com.example.socialpets.data.repository

import com.example.socialpets.Pet
import com.example.socialpets.Profile
import com.example.socialpets.R

object ProfileRepository {

    suspend fun getProfile(): Profile {
        return Profile(name = "Luda", age = "17", photo =  R.drawable.img_4, pets = arrayOf(
            Pet("Pes", R.drawable.img, "Ovcharka"),
            Pet("Murzik", R.drawable.img_1, "Ovcharka"),
            Pet("Lox", R.drawable.img_2, "Ovcharka"),
            Pet("Kesha", R.drawable.img_3, "Ovcharka")
        ).toList(), bio = "Young beauty model")
    }
}