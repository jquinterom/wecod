package com.example.wecod.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.wecod.R
import com.example.wecod.ui.theme.WeCodTheme

@Composable
fun WeaponCard() {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (image, description, rate) = createRefs()

            SubcomposeAsyncImage(
                modifier = Modifier
                    .clickable { }
                    .fillMaxHeight()
                    .fillMaxWidth(.4f)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .clip(shape = RoundedCornerShape(5.dp)),
                model = "https://i.ytimg.com/vi/xRp0l_qZi9Y/maxresdefault.jpg",
                contentDescription = null,
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

            DescriptionWeapon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()
                    .constrainAs(description) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Stars(
                modifier = Modifier
                    .padding(bottom = 2.dp, end = 4.dp)
                    .constrainAs(rate) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@Composable
fun DescriptionWeapon(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "DQL", modifier = Modifier.fillMaxHeight())
        Text(
            modifier = Modifier.fillMaxHeight(),
            text = "Sniper"
        )
    }
}

@Composable
fun Stars(modifier: Modifier) {
    Row(
        modifier = modifier
    ) {
        LazyRow {
            items(5) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_star_border_24),
                    contentDescription = null
                )
            }
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