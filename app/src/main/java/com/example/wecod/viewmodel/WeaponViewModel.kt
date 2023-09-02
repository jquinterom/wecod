package com.example.wecod.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.CustomWeapon
import com.example.wecod.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponViewModel @Inject constructor(
    private val weaponRepository: WeaponTask,
) : ViewModel() {
    var customWeaponList = mutableStateOf<List<CustomWeapon>>(listOf())
        private set

    var weaponList = mutableStateOf<List<Weapon>>(listOf())
        private set

    var status = mutableStateOf<ApiResponseStatus<Any>?>(null)
    private set

    init {
        getAllCustomWeapons()

        getAllWeapons()
    }

    private fun getAllCustomWeapons() {
        viewModelScope.launch {
            status.value = ApiResponseStatus.Loading()
            handleResponseStatusCustomWeapons(weaponRepository.getAllCustomWeapons())
        }
    }


    private fun getAllWeapons() {
        viewModelScope.launch {
            status.value = ApiResponseStatus.Loading()
            handleResponseStatusWeapons(weaponRepository.getAllWeapons())
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponseStatusCustomWeapons(
        apiResponseStatusListCustomWeapon: ApiResponseStatus<List<CustomWeapon>>
    ) {
        if (apiResponseStatusListCustomWeapon is ApiResponseStatus.Success) {
            customWeaponList.value = apiResponseStatusListCustomWeapon.data
        }
        status.value = apiResponseStatusListCustomWeapon as ApiResponseStatus<Any>
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponseStatusWeapons(
        apiResponseStatusListWeapon: ApiResponseStatus<List<Weapon>>
    ) {
        if (apiResponseStatusListWeapon is ApiResponseStatus.Success) {
            weaponList.value = apiResponseStatusListWeapon.data
        }
        status.value = apiResponseStatusListWeapon as ApiResponseStatus<Any>
    }

}