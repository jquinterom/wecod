package com.example.wecod.interfaces

import com.example.wecod.model.Weapon

interface WeaponTask {
    suspend fun getAllWeapons() : List<Weapon>
}