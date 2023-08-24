package com.example.wecod.interfaces

import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.model.CustomWeapon

interface WeaponTask {
    suspend fun getAllWeapons() : ApiResponseStatus<List<CustomWeapon>>
}