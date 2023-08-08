package com.example.wecod.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.wecod.R
import com.example.wecod.ui.theme.WeCodTheme

@Composable
fun WeaponCard() {
    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            SubcomposeAsyncImage(
                model = "https://i.ytimg.com/vi/xRp0l_qZi9Y/maxresdefault.jpg",
                contentDescription = null,
                modifier = Modifier
                    .clickable { }
                    .fillMaxHeight()
                    .fillMaxWidth(.4f),
                alignment = Alignment.TopStart,
            ) {
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    Box(
                        modifier = Modifier.clickable { },
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    SubcomposeAsyncImageContent()
                }
            }

            DescriptionWeapon()
            Stars()
        }
    }
}

@Composable
fun DescriptionWeapon() {
    Column() {
        Text(text = "DQL")
        Text(text = "Sniper")
    }
}

@Composable
fun Stars() {
    Row {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_border_24),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeaponCardPreview() {
    WeCodTheme {
        WeaponCard()
    }
}