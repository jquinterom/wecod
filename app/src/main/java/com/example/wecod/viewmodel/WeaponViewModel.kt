package com.example.wecod.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wecod.interfaces.WeaponTask
import com.example.wecod.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponViewModel @Inject constructor(
    // private val weaponRepository: WeaponTask,
) : ViewModel() {
    var weaponList = mutableStateOf<List<Weapon>>(listOf())
        private set


    init {
        getAllWeapons()
    }

    private fun getAllWeapons() {
        viewModelScope.launch {
            // weaponList.value = weaponRepository.getAllWeapons()

            Log.d("weaponList", weaponList.value.toString())
        }
    }

}