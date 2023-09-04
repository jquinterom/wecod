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
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.wecod.constants.FAKE_CUSTOM_WEAPON
import com.example.wecod.constants.MAX_RATE
import com.example.wecod.model.CustomWeapon
import com.example.wecod.ui.theme.WeCodTheme

@Composable
fun CustomWeaponCard(
    fakeCustomWeapon: CustomWeapon
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

            ImageCard(modifier = Modifier
                .clickable { }
                .fillMaxHeight()
                .fillMaxWidth(.4f)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }, urlModel = fakeCustomWeapon.imgUrl
            )

            DescriptionWeapon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()
                    .constrainAs(description) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                fakeCustomWeapon
            )

            Rate(
                modifier = Modifier
                    .padding(bottom = 2.dp, end = 4.dp)
                    .constrainAs(rate) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                fakeCustomWeapon
            )
        }
    }
}

@Composable
fun DescriptionWeapon(modifier: Modifier, fakeCustomWeapon: CustomWeapon) {
    Column(
        modifier = modifier
    ) {
        Text(text = fakeCustomWeapon.name, modifier = Modifier.fillMaxHeight())
        Text(text = fakeCustomWeapon.category.toString(), modifier = Modifier.fillMaxHeight())
        Text(
            text = fakeCustomWeapon.gameMode,
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
fun Rate(modifier: Modifier, fakeCustomWeapon: CustomWeapon) {
    Row(
        modifier = modifier
    ) {
        LazyRow {
            items(fakeCustomWeapon.rate.toInt()) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = null,
                    tint = Color.Yellow,
                )
            }
        }

        for (a in fakeCustomWeapon.rate.toInt()..MAX_RATE) {
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color.Gray,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomWeaponCardPreview() {
    WeCodTheme {
        CustomWeaponCard(FAKE_CUSTOM_WEAPON)
    }
}