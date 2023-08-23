package com.example.wecod.di

import com.example.wecod.api.repository.WeaponRepository
import com.example.wecod.interfaces.WeaponTask
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WeaponTasksModule {
    @Binds
    abstract fun bindWeaponTasks(
        weaponRepository: WeaponRepository,
    ): WeaponTask
}