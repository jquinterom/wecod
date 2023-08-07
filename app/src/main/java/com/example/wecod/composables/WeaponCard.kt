package com.example.wecod.composables

import androidx.compose.foundation.border
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wecod.ui.theme.WeCodTheme

@Composable
fun WeaponCard() {
    Card(
        modifier = Modifier
    ) {
        Text("card view")
    }
}

@Preview(showBackground = true)
@Composable
fun WeaponCardPreview() {
    WeCodTheme {
        WeaponCard()
    }
}