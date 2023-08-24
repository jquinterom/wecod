package com.example.wecod.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.constants.FAKE_CUSTOM_WEAPONS
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.CustomWeapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class WeaponViewModel @Inject constructor(
    private val weaponRepository: WeaponTask,
) : ViewModel() {
    var customWeaponList = mutableStateOf<List<CustomWeapon>>(listOf())
        private set

    init {
        getAllWeapons()
    }

    private fun getAllWeapons() {
        viewModelScope.launch {
            handleResponseStatusCustomWeapons(weaponRepository.getAllWeapons())
        }

    }


    private fun handleResponseStatusCustomWeapons(
        apiResponseStatusListCustomWeapon: ApiResponseStatus<List<CustomWeapon>>
    ) {
        if (apiResponseStatusListCustomWeapon is ApiResponseStatus.Success) {
            viewModelScope.launch {
                val customWeaponApi = apiResponseStatusListCustomWeapon.data.map { it }
                customWeaponList.value = customWeaponApi
            }
        }

    }

}