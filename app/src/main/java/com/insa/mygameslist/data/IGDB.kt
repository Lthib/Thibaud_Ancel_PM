package com.insa.mygameslist.data

import android.content.Context
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.insa.mygameslist.R
import com.insa.mygameslist.ui.theme.GameViewModel

object IGDB {

    lateinit var covers: Map<Long,Cover>
    lateinit var games: Map<Long,Game>
    lateinit var genres: Map<Long,Genre>
    lateinit var platform_logos : Map<Long,Plat_logo>
    lateinit var platforms : Map<Long,Plat>

    var favs : SnapshotStateMap<Long, Boolean> = mutableStateMapOf<Long,Boolean>()

    fun load(context: Context) {
        val coversFromJson: List<Cover> = Gson().fromJson(
            context.resources.openRawResource(R.raw.covers).bufferedReader(),
            object : TypeToken<List<Cover>>() {}.type
        )
        val GamesFromJson: List<Game> = Gson().fromJson(
            context.resources.openRawResource(R.raw.games).bufferedReader(),
            object : TypeToken<List<Game>>() {}.type
        )
        val GenresFromJson: List<Genre> = Gson().fromJson(
            context.resources.openRawResource(R.raw.genres).bufferedReader(),
            object : TypeToken<List<Genre>>() {}.type
        )
        val Plats_logoFromJson: List<Plat_logo> = Gson().fromJson(
            context.resources.openRawResource(R.raw.platform_logos).bufferedReader(),
            object : TypeToken<List<Plat_logo>>() {}.type
        )
        val PlatsFromJson: List<Plat> = Gson().fromJson(
            context.resources.openRawResource(R.raw.platforms).bufferedReader(),
            object : TypeToken<List<Plat>>() {}.type
        )
        covers = coversFromJson.associateBy{it.id}
        games = GamesFromJson.associateBy { it.id }
        genres = GenresFromJson.associateBy { it.id }
        platform_logos = Plats_logoFromJson.associateBy { it.id }
        platforms = PlatsFromJson.associateBy { it.id }
        games.forEach { favs[it.key]=false }

    }
}

data class Cover(val id: Long, val url: String)
data class Game(val id:Long,val cover:Long,val first_release_date : Long,val genres:List<Long>,val name : String,val platforms:List<Long>,val summary : String,val total_rating: Float)
data class Genre(val id:Long, val name:String)
data class Plat_logo(val id :Long,val url:String)
data class Plat(val id :Long,val name :String,val platform_logo:Long)