package com.example.wecod.di

import android.content.Context
import androidx.room.Room
import com.example.wecod.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoomInstance(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "wecod-db"
    ).build()

    @Singleton
    @Provides
    fun provideWeaponDao(db: AppDatabase) = db.weaponDao()
}