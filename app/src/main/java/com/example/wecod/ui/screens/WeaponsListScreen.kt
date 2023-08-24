package com.example.wecod.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wecod.ui.composables.WeaponCard
import com.example.wecod.ui.theme.WeCodTheme
import com.example.wecod.viewmodel.WeaponViewModel


@Composable
fun WeaponsListScreen(
    viewModel: WeaponViewModel = hiltViewModel()
) {
    val weaponsList = viewModel.customWeaponList.value

    LazyColumn {
        items(weaponsList) { weapon ->
            WeaponCard(weapon)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeCodTheme {
        WeaponsListScreen()
    }
}