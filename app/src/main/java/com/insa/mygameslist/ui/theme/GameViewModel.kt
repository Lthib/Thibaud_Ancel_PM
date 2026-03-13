package com.insa.mygameslist.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.insa.mygameslist.data.Game
import com.insa.mygameslist.data.IGDB


class GameViewModel : ViewModel() {
    val textState = mutableStateOf(TextFieldValue(""))
    var mutgame by mutableStateOf(IGDB.games)
    val filteredgames: Map<Long, Game>
        get() = IGDB.games.filterValues {
            it.name.contains(textState.value.text, ignoreCase = true) ||
                    it.genres.any {
                        if (IGDB.genres.get(it) != null) {
                            IGDB.genres.get(it)!!
                                .name.contains(
                                    textState
                                        .value.text, ignoreCase = true
                                )
                        } else {
                            false
                        }
                    } ||
                    it.platforms.any {
                        if (IGDB.platforms.get(it) != null) {
                            IGDB.platforms.get(it)!!.name.contains(
                                textState.value.text,
                                ignoreCase = true
                            )
                        } else {
                            false
                        }

                    }
        }
}