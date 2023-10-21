package com.example.x_o.game.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class GameModeButton(
    public val text: String,
    public val selected: Boolean,
    public val onSelected: () -> Unit
) {

    @Composable
    operator fun invoke() {
        val selection = rememberUpdatedState(selected)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(180.dp)
                .background(color = Color.White)
                .padding(8.dp)
        ) {
            RadioButton(
                selected = selection.value,
                onClick = { onSelected() },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFFfa5552)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text, fontSize = 15.sp)
        }
    }
}
