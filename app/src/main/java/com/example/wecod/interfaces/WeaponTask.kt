package com.example.wecod.interfaces

import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.model.CustomWeapon
import com.example.wecod.model.Weapon

interface WeaponTask {
    suspend fun getAllCustomWeapons() : ApiResponseStatus<List<CustomWeapon>>
    suspend fun getAllWeapons() : ApiResponseStatus<List<Weapon>>
}