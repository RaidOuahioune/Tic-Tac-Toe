package com.example.x_o.game.composables

import android.os.Build
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class GameBoard(public val vibrator: Vibrator) {
    @RequiresApi(Build.VERSION_CODES.R)
    @Composable
    fun get(board: List<Char>, onCellClick: (Int) -> Unit) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(board.chunked(3)) { rowIndex ,row->

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(400.dp)
                        .padding(vertical = 10.dp)
                ) {
                    row.forEachIndexed { index, cell ->
                        GameCell(vibrator).get(cell) { onCellClick(3 * rowIndex + index) }
                    }
                }
            }
        }
    }
}