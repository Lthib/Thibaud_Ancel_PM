package com.insa.mygameslist.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.insa.mygameslist.R
import com.insa.mygameslist.data.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCardList(src:Map<Long,Game>, modifier: Modifier,backStack: SnapshotStateList<Any>){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(227, 153, 126),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("My Games List") },
                navigationIcon = {
                    IconButton(onClick = { backStack.removeLastOrNull() }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_24),
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
            LazyColumn(Modifier.padding(innerPadding)) {
                items(src.values.toList()) {
                    Spacer(Modifier.padding(2.dp))
                    GameCard(it, backStack)
                    Spacer(Modifier.padding(2.dp))
                }
            }
        }
}