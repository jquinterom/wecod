package com.example.wecod.api

import com.example.wecod.api.dto.WeaponDTO
import com.example.wecod.constants.GET_ALL_WEAPONS_URL
import retrofit2.http.GET

interface ApiService {
    @GET(GET_ALL_WEAPONS_URL)
    //suspend fun getAllPosts(): PostListApiResponse
    suspend fun getAllPosts(): List<WeaponDTO>
}