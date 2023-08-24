package com.example.wecod.api.repository

import android.util.Log
import com.example.wecod.R
import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.api.ApiService
import com.example.wecod.api.dto.mappers.CustomWeaponDTOMapper
import com.example.wecod.api.makeNetworkCall
import com.example.wecod.database.AppDatabase
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.CustomWeapon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeaponRepository @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher
) : WeaponTask {
    override suspend fun getAllWeapons(): ApiResponseStatus<List<CustomWeapon>> {
        return withContext(dispatcher) {
            val allCustomWeapons = async { downloadCustomWeapons() }

            when (val allCustomWeaponListResponse = allCustomWeapons.await()) {
                is ApiResponseStatus.Error -> {
                    allCustomWeaponListResponse
                }

                is ApiResponseStatus.Success -> {
                    ApiResponseStatus.Success(
                        getCollectionCustomWeaponsList(allCustomWeaponListResponse.data)
                    )
                }

                else -> {
                    ApiResponseStatus.Error(R.string.error_connecting_server)
                }
            }
        }
    }


    private suspend fun downloadCustomWeapons(): ApiResponseStatus<List<CustomWeapon>> =
        makeNetworkCall {
            val customWeaponListApiResponse = apiService.getAllWeapons()
            val customWeaponDTOMapper = CustomWeaponDTOMapper()
            customWeaponDTOMapper.fromCustomWeaponDTOListToCustomWeaponDomainList(
                customWeaponListApiResponse
            )
        }

    private fun getCollectionCustomWeaponsList(allCustomWeaponsList: List<CustomWeapon>) =
        allCustomWeaponsList.map { it }
}