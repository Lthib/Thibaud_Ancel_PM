package com.insa.mygameslist


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.insa.mygameslist.data.IGDB
import com.insa.mygameslist.ui.theme.GameCardList
import com.insa.mygameslist.ui.theme.GameDetail
import com.insa.mygameslist.ui.theme.MyGamesListTheme
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data class  Product(val id: Long)



@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {


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
                                    GameCardList(Modifier.fillMaxSize(),backStack)
                                }
                                is Product -> NavEntry(key){
                                    GameDetail(backStack,key.id, IGDB.games)
                                }
                                else -> NavEntry(Unit) { Text("Unknown route") }
                            }
                        })


            }
        }
    }
}