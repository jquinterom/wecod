package com.example.wecod.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.padding(end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubcomposeAsyncImage(
                    model = "https://i.ytimg.com/vi/xRp0l_qZi9Y/maxresdefault.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth(.4f)
                        .clip(RoundedCornerShape(5.dp)),
                    alignment = Alignment.TopStart,
                    contentScale = ContentScale.Crop,
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

                Spacer(modifier = Modifier.width(8.dp))
                DescriptionWeapon()
            }
        }
    }
}

@Composable
fun DescriptionWeapon() {
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "DQL")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Sniper")

        Stars()
    }
}

@Composable
fun Stars() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.End,
    ) {
        Row {
            for (i in 1..5) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_star_border_24),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun WeaponCardPreview() {
    WeCodTheme {
        WeaponCard()
    }
}