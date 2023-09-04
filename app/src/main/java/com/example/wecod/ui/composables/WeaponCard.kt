package com.example.wecod.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.wecod.constants.FAKE_WEAPON
import com.example.wecod.model.Weapon
import com.example.wecod.ui.theme.WeCodTheme


@Composable
fun WeaponCard(weapon: Weapon) {
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
            val (image, imageName, category) = createRefs()
            ImageCard(
                modifier = Modifier
                    .clickable { }
                    .fillMaxHeight()
                    .fillMaxWidth(.4f)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                weapon.imgUrl
            )

            Text(text = weapon.name, modifier = Modifier.constrainAs(imageName){
                start.linkTo(image.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
            Text(text = weapon.category.name,
                modifier = Modifier.constrainAs(category){
                    start.linkTo(image.end)
                    top.linkTo(imageName.bottom)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeaponCardPreview() {
    WeCodTheme {
        WeaponCard(FAKE_WEAPON)
    }
}