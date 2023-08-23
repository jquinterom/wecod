package com.example.wecod.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.wecod.model.Weapon

@Dao
interface WeaponDao {

    @Query("SELECT * FROM Weapon WHERE id = :weaponId")
    suspend fun getWeaponById(weaponId: Int) : Weapon
}