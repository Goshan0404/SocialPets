package com.example.socialpets.data

import com.example.socialpets.Resources
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApi {

    @GET
    suspend fun getProfile(
        @Query("id") id: Int
    ): Response<Resources>
}