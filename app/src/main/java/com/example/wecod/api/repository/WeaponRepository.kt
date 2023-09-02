package com.example.wecod.api.repository

import com.example.wecod.R
import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.api.ApiService
import com.example.wecod.api.dto.mappers.CustomWeaponDTOMapper
import com.example.wecod.api.dto.mappers.WeaponDTOMapper
import com.example.wecod.api.makeNetworkCall
import com.example.wecod.database.AppDatabase
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.CustomWeapon
import com.example.wecod.model.Weapon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeaponRepository @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher
) : WeaponTask {
    override suspend fun getAllCustomWeapons(): ApiResponseStatus<List<CustomWeapon>> {
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

    override suspend fun getAllWeapons(): ApiResponseStatus<List<Weapon>> {
        return withContext(dispatcher) {
            val allWeapons = async { downloadWeapons() }

            when (val allWeaponListResponse = allWeapons.await()) {
                is ApiResponseStatus.Error -> {
                    allWeaponListResponse
                }

                is ApiResponseStatus.Success -> {
                    ApiResponseStatus.Success(
                        getCollectionWeaponsList(allWeaponListResponse.data)
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
            val customWeaponListApiResponse = apiService.getAllCustomWeapons()
            val customWeaponDTOMapper = CustomWeaponDTOMapper()
            customWeaponDTOMapper.fromCustomWeaponDTOListToCustomWeaponDomainList(
                customWeaponListApiResponse
            )
        }


    private suspend fun downloadWeapons(): ApiResponseStatus<List<Weapon>> =
        makeNetworkCall {
            val weaponListApiResponse = apiService.getAllWeapons()
            val weaponDTOMapper = WeaponDTOMapper()
            weaponDTOMapper.fromCustomWeaponDTOListToCustomWeaponDomainList(
                weaponListApiResponse
            )
        }

    private fun getCollectionCustomWeaponsList(allCustomWeaponsList: List<CustomWeapon>) =
        allCustomWeaponsList.map { it }

    private fun getCollectionWeaponsList(allWeaponsList: List<Weapon>) =
        allWeaponsList.map { it }
}