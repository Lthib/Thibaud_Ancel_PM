package com.insa.mygameslist.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.insa.mygameslist.data.Game

@Composable
fun GameCardList(src:List<Game>, modifier: Modifier){
    LazyColumn(modifier) {
        items(src.size) { index ->
            Spacer(Modifier.padding(2.dp))
            GameCard(src[index])
            Spacer(Modifier.padding(2.dp))
        }
    }
}