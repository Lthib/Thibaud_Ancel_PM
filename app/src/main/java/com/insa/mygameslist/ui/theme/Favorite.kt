package com.insa.mygameslist.ui.theme


import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import com.insa.mygameslist.R
import com.insa.mygameslist.data.IGDB

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(255, 233, 30),
    id : Long

) {

    val isFavorite = IGDB.favs.get(id) ?: false

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