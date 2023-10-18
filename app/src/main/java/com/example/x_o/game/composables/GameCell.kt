package com.example.x_o.game.composables


import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class GameCell(public val vibrator: Vibrator) {
    @RequiresApi(Build.VERSION_CODES.S)
    @Composable
    fun get(value: Char, onCellClick: () -> Unit) {
        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clickable {
                    if(value!=' ' ){
                        vibrator.vibrate( VibrationEffect.createOneShot (90,VibrationEffect.EFFECT_TICK))
                    }else{
                        onCellClick()
                    }
                },
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = if (value == 'O') "O" else if (value == 'X') "X" else "", // Show 'O' for 'O', 'X' for 'X', and nothing for an empty cell
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (value == 'O') Color.Green else if (value == 'X') Color.Red else Color.Black, // Set text color to green for 'O', red for 'X', and white for an empty cell
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}