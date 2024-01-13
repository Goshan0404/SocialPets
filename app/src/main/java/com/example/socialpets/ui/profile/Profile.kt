package com.example.socialpets.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.socialpets.Pet
import com.example.socialpets.R
import com.example.socialpets.Profile
import dagger.hilt.android.scopes.ViewModelScoped

@Composable
fun Profile(viewModel: ProfileViewModel = hiltViewModel()) {

    val profileData = viewModel.getProfileData()

    Column {

        OwnerCard(profileData)

        Divider(Modifier.padding(horizontal = 5.dp))

        PetsList(profileData)
    }

}

@Composable
private fun PetsList(profileData: Profile) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(5.dp)) {
        items(profileData.pets) { pet ->
            Card(modifier = Modifier.padding(5.dp)) {
                Text(text = pet.name, Modifier.padding(start = 3.dp, top = 3.dp))
                Image(
                    painter = painterResource(id = pet.photo), contentDescription = null,
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
private fun OwnerCard(profileData: Profile) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = profileData.photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(220.dp),
                contentDescription = null
            )

            Column {

                Text(
                    text = profileData.name,
                    Modifier.padding(start = 3.dp, top = 3.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${profileData.bio} y.o",
                    Modifier.padding(start = 3.dp, top = 3.dp),
                    textAlign = TextAlign.Center
                )
                Divider()
                Text(text = "About me")
                Text(text = profileData.bio)
            }
        }
    }
}