package com.insa.mygameslist.ui.theme


import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.insa.mygameslist.R
import com.insa.mygameslist.data.IGDB

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(255, 233, 30),
    id : Long

) {

    var isFavorite = IGDB.favs.get(id) ?: false

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            IGDB.favs[id] = !isFavorite
        },
        modifier = modifier
    ) {
        Icon(

            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.2f
                scaleY = 1.2f
            },
            painter = if (isFavorite) {
                painterResource(R.drawable.etoilepleine)
            } else {
                painterResource(R.drawable.etoilevide)
            },
            contentDescription = null
        )
    }

}