package com.insa.mygameslist.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.insa.mygameslist.Product
import com.insa.mygameslist.R
import com.insa.mygameslist.data.Cover
import com.insa.mygameslist.data.Game
import com.insa.mygameslist.data.IGDB

@Composable
fun GameCard(game : Game,backStack: SnapshotStateList<Any>) {

    val genres:String = game.genres.filter { IGDB.genres.containsKey(it) }.map { it -> IGDB.genres.get(it)!!.name }.joinToString(" , " )
    Row(
            Modifier.fillMaxWidth().clickable(onClick = {backStack.add(Product(game.id))})
                .background(color = Color(136, 199, 188), shape = RoundedCornerShape(20.dp))
        ) {
            AsyncImage(
                model = "https:" + IGDB.covers.get(game.cover)!!.url,
                contentDescription = "jeu",
                Modifier.padding(top = 10.dp, bottom = 10.dp, start = 25.dp)
            )
            Column(Modifier.padding(top = 10.dp, start = 15.dp)) {
                Text(
                    game.name,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(genres, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }

        }

}