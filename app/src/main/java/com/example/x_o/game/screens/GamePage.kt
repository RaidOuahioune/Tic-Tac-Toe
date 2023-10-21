package com.example.x_o.game.screens

import TicTacToeViewModel
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.x_o.game.composables.GameBoard
import com.example.x_o.game.composables.GameDialog


class GamePage(public val vibrator: Vibrator, private val viewModel: TicTacToeViewModel) {
    @RequiresApi(Build.VERSION_CODES.R)
    @Composable
    operator fun invoke() {
        val board = viewModel.board

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (!viewModel.gameInProgress) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.EFFECT_TICK))
                GameDialog(vibrator = vibrator, viewModel)()
            }
            GameBoard(vibrator, board.value!!, viewModel::onCellClick)()
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFfa5552),
                    contentColor = Color.White
                ),
                onClick = { viewModel.resetGame() }) {
                Text("Reset Game")
            }
        }
    }


}




