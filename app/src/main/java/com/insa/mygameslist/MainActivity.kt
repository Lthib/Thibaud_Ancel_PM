package com.insa.mygameslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil3.compose.AsyncImage
import com.insa.mygameslist.data.IGDB
import com.insa.mygameslist.ui.theme.GameCard
import com.insa.mygameslist.ui.theme.GameCardList
import com.insa.mygameslist.ui.theme.MyGamesListTheme
import com.insa.mygameslist.ui.theme.PrevGameCard

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IGDB.load(this)

        enableEdgeToEdge()
        setContent {

            MyGamesListTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = Color(227, 153, 126),
                                titleContentColor = Color.Black,
                            ),
                            title = { Text("My Games List") })
                    },
                    containerColor = Color(2, 154, 158),
                    contentWindowInsets = WindowInsets.systemBars,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    GameCardList(IGDB.games,Modifier.padding(innerPadding))
                    //Text("À remplir", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}