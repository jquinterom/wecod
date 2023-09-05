package com.example.wecod.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wecod.api.ApiResponseStatus
import com.example.wecod.ui.composables.ErrorDialog
import com.example.wecod.ui.composables.LoadingWheel
import com.example.wecod.ui.composables.CustomWeaponCard
import com.example.wecod.ui.theme.WeCodTheme
import com.example.wecod.viewmodel.WeaponViewModel


@Composable
fun CustomWeaponsListScreen(
    viewModel: WeaponViewModel = hiltViewModel()
) {
    val customWeaponsList = viewModel.customWeaponList.value
    val status = viewModel.status.value

    LazyColumn {
        items(customWeaponsList) { customWeapon ->
            CustomWeaponCard(customWeapon)
        }
    }

    if (status is ApiResponseStatus.Loading) {
        LoadingWheel()
    } else if (status is ApiResponseStatus.Error) {
        ErrorDialog(messageId = status.messageId, onErrorDialogDismiss = {})
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeCodTheme {
        CustomWeaponsListScreen()
    }
}