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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.wecod.model.Weapon
import com.example.wecod.ui.theme.WeCodTheme
import com.example.wecod.viewmodel.WeaponViewModel

@Composable
fun WeaponCard(
    viewModel: WeaponViewModel = hiltViewModel()
) {
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
                model = viewModel.fakeWeapon.imgUrl,
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
                    },
                viewModel.fakeWeapon
            )

            Rate(
                modifier = Modifier
                    .padding(bottom = 2.dp, end = 4.dp)
                    .constrainAs(rate) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                viewModel.fakeWeapon
            )
        }
    }
}

@Composable
fun DescriptionWeapon(modifier: Modifier, fakeWeapon: Weapon) {
    Column(
        modifier = modifier
    ) {
        Text(text = fakeWeapon.name, modifier = Modifier.fillMaxHeight())
        Text(text = fakeWeapon.category, modifier = Modifier.fillMaxHeight())
        Text(
            text = fakeWeapon.gameMode,
            modifier = Modifier.fillMaxHeight(),
            style = TextStyle(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        )

    }
}

@Composable
fun Rate(modifier: Modifier, fakeWeapon: Weapon) {
    Row(
        modifier = modifier
    ) {
        for (a in fakeWeapon.rate.toInt()..4) {
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color.Black,
            )
        }

        LazyRow {
            items(fakeWeapon.rate.toInt()) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = null,
                    tint = Color.Yellow,
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