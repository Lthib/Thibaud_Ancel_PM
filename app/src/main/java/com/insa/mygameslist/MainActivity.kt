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
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import coil3.compose.AsyncImage
import coil3.imageLoader
import com.insa.mygameslist.data.IGDB
import com.insa.mygameslist.ui.theme.GameCard
import com.insa.mygameslist.ui.theme.GameCardList
import com.insa.mygameslist.ui.theme.GameDetail
import com.insa.mygameslist.ui.theme.MyGamesListTheme
import com.insa.mygameslist.ui.theme.PrevGameCard
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data class  Product(val id: Long)



@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    var nompage : String ="My Games List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IGDB.load(this)


        enableEdgeToEdge()
        setContent {
            val backStack = remember { mutableStateListOf<Any>(Home) }
            MyGamesListTheme {
                    NavDisplay(
                        backStack=backStack,
                        onBack = {backStack.removeLastOrNull()},
                        entryProvider = { key ->
                            when(key) {
                                is Home -> NavEntry(key) {
                                    GameCardList(IGDB.games, Modifier.fillMaxSize(),backStack)
                                }
                                is Product -> NavEntry(key){
                                    GameDetail(backStack,key.id, IGDB.games)
                                }
                                else -> NavEntry(Unit) { Text("Unknown route") }
                            }
                        })
                    //Text("À remplir", modifier = Modifier.padding(innerPadding))

            }
        }
    }
}