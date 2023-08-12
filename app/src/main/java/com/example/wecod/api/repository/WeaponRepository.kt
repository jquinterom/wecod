package com.example.wecod.api.repository

import com.example.wecod.constants.FAKE_WEAPONS
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.Weapon
import javax.inject.Inject

class WeaponRepository @Inject constructor() : WeaponTask {
    // override suspend fun getAllWeapons() : List<Weapon> = FAKE_WEAPONS.map { it }
    override suspend fun getAllWeapons(): List<Weapon> {
        TODO("Not yet implemented")
    }
}