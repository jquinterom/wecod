package com.example.wecod.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.wecod.constants.FAKE_WEAPON
import com.example.wecod.ui.composables.WeaponCard
import com.example.wecod.ui.theme.WeCodTheme

@Composable
fun WeaponsListScreen(){
    LazyColumn {
        items(3) {
            WeaponCard(FAKE_WEAPON)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeaponsListScreenPreview() {
    WeCodTheme {
        WeaponsListScreen()
    }
}