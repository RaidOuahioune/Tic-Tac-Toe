package com.example.x_o.game.composables
import TicTacToeViewModel
import android.os.Vibrator
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
class GameDialog(vibrator: Vibrator) {
    @Preview(showBackground = true)
    @Composable
    public fun get(viewModel:TicTacToeViewModel=TicTacToeViewModel()){
        Dialog(
            onDismissRequest = {
                viewModel.gameInProgress = true
            }
        ) {
            Column(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxSize()
                    .padding(16.dp)
                   .border(
                        1.dp,
                        Color.Red,
                        shape = RoundedCornerShape(8.dp),
                    ).background(Color.White,  shape = RoundedCornerShape(8.dp),),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = (if(viewModel.winner=="") "Draw" else (if(viewModel.isSinglePlayer==true) if(viewModel.winner=="2") "Ai Won the Game"  else "Player ${viewModel.winner}  Won the Game" else  "Player ${viewModel.winner}  Won the Game" )),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if(viewModel.winner== "")Color.Blue else if(viewModel.winner=="1")Color.Red else Color.Green, // Change text color to blue
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.gameInProgress = true
                        viewModel.resetGame()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFfa5552), contentColor = Color.White)
                ) {
                    Text("New Game", color = Color.White)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}