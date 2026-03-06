package com.insa.mygameslist.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    placeholder: String,
    modifier: Modifier,
    onvalueChange: () -> (Any)
) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
            onvalueChange()
        },
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, Color.DarkGray, RoundedCornerShape(30.dp)),
        placeholder = {
            Text(text = placeholder)
        },
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(color = Color.Black, fontSize = 20.sp)
    )
}

