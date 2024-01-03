package com.example.socialpets.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialpets.R
import com.example.socialpets.Resources

val resources = arrayOf(
    Resources("Pes", R.drawable.img),
    Resources("Murzik", R.drawable.img_1),
    Resources("Lox", R.drawable.img_2),
    Resources("Kesha", R.drawable.img_3)
)

@Preview
@Composable
fun Profile() {
    Column {

        OwnerCard()

        Divider(Modifier.padding(horizontal = 5.dp))

        PetsList()
    }

}

@Composable
private fun PetsList() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(5.dp)) {
        items(resources) { r ->
            Card(modifier = Modifier.padding(5.dp)) {
                Text(text = r.name, Modifier.padding(start = 3.dp, top = 3.dp))
                Image(
                    painter = painterResource(id = r.photo), contentDescription = null,
                    contentScale = ContentScale.Crop, modifier = Modifier
                        .size(200.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                )

            }
        }
    }
}

@Composable
private fun OwnerCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.img_4),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(220.dp),
                contentDescription = null
            )

            Column {

                Text(
                    text = "Luda",
                    Modifier.padding(start = 3.dp, top = 3.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "18 y.o",
                    Modifier.padding(start = 3.dp, top = 3.dp),
                    textAlign = TextAlign.Center
                )
                Divider()
                Text(text = "About me")
                Text(text = "Young beauty model")
            }
        }
    }
}