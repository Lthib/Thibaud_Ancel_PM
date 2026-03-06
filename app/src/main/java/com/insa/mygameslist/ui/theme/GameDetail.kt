package com.insa.mygameslist.ui.theme

import android.icu.number.Scale
import android.icu.text.CaseMap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.insa.mygameslist.R
import com.insa.mygameslist.data.Game
import com.insa.mygameslist.data.IGDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetail(backStack: SnapshotStateList<Any>,id:Long, src:Map<Long,Game>){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(227, 153, 126),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("${src.get(id)!!.name}") },
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
        Column(modifier=Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${src.get(id)!!.name}",
                modifier = Modifier.padding(top=5.dp),
                textAlign = TextAlign.Center
            )
            AsyncImage(
                model = "https:" + IGDB.covers.get(src.get(id)!!.cover)!!.url,
                contentDescription = "jeu",
                Modifier.padding(top = 5.dp, bottom = 5.dp).height(250.dp),
                alignment = Alignment.Center,
            )
            LazyRow() {
                items(src.get(id)!!.platforms){items->
                    AsyncImage(
                        model = if(IGDB.platform_logos.get(IGDB.platforms.get(items)!!.platform_logo)!=null){
                            "https:" + IGDB.platform_logos.get(IGDB.platforms.get(items)!!.platform_logo)!!.url
                        }else{
                            R.drawable.baseline_no_photography_24
                             },
                        contentDescription = "jeu",
                        Modifier.padding(top = 5.dp, bottom = 5.dp, start=5.dp,end = 5.dp).height(50.dp),
                        alignment = Alignment.Center,
                    )
                }
            }
        }

    }
}