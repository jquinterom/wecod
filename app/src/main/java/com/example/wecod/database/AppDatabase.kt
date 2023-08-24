package com.example.wecod.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wecod.database.dao.WeaponDao
import com.example.wecod.model.CustomWeapon

@Database(entities = [CustomWeapon::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weaponDao() : WeaponDao
}