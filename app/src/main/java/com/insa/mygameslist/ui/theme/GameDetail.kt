package com.insa.mygameslist.ui.theme

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.insa.mygameslist.R
import com.insa.mygameslist.data.Game
import com.insa.mygameslist.data.IGDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetail(backStack: SnapshotStateList<Any>, id: Long, src: Map<Long, Game>) {
    var game: Game = src.get(id)!! //Dans cette classe on est sûr que l'objet existe, on se permet des simplicités
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(227, 153, 126),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(game.name)
                },
                navigationIcon = {
                    IconButton(onClick = { backStack.removeLastOrNull() }) {
                        Icon(
                            painter = painterResource(R.drawable.backarrow),
                            contentDescription = "Localized description"
                        )
                    }
                }
            )

        },
        containerColor = Color(2, 154, 158),
        contentWindowInsets = WindowInsets.systemBars,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->



        Box(modifier = Modifier.padding(innerPadding)) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item() {

                    Text(
                        game.name,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 30.sp,
                        lineHeight = 35.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                }

                item() {
                    AsyncImage(
                        model = "https:" + IGDB.covers.get(game.cover)?.url,
                        contentDescription = "jeu",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .height(250.dp)
                            .padding(top = 15.dp, bottom = 5.dp)
                    )
                }

                item() {
                    val genres: String = game.genres.filter { IGDB.genres.containsKey(it) }
                        .joinToString(" , ") { it -> IGDB.genres.get(it)!!.name }
                    Text(
                        genres,
                        fontStyle = FontStyle.Italic,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

                item() {
                    LazyRow() {
                        items(src.get(id)!!.platforms) { items ->
                            AsyncImage(
                                model = if (IGDB.platform_logos.get(IGDB.platforms.get(items)!!.platform_logo) != null) {
                                    "https:" + IGDB.platform_logos.get(IGDB.platforms.get(items)!!.platform_logo)!!.url
                                } else {
                                    R.drawable.baseline_no_photography_24
                                },
                                contentDescription = "jeu",
                                Modifier
                                    .padding(top = 5.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
                                    .height(50.dp),
                                alignment = Alignment.Center,
                            )
                        }
                    }
                }

                item() {
                    Text(
                        game.summary,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                }


            }
            Surface(

                shape = RectangleShape,
                modifier = Modifier

                    .align(Alignment.TopEnd)
                    .padding(),

                color = Color(0x00000000)
            ) {
                FavoriteButton(modifier = Modifier, id = game.id)

            }

        }


    }

}

