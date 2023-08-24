package com.example.wecod.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.wecod.model.CustomWeapon

@Dao
interface WeaponDao {

    @Query("SELECT * FROM CustomWeapon WHERE id = :weaponId")
    suspend fun getWeaponById(weaponId: Int) : CustomWeapon
}