package com.example.x_o.game.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.x_o.game.data.dto.Game


class GameItem(public val game: Game) {
    @Composable
    operator fun invoke() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            ) {
            Column(

                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Game ID: ${game.id}",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Winner: ${game.value.winner ?: "None"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Clients: ${game.value.clients.joinToString()}"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Password: ${game.value.password ?: "No password"}"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Join Game", color = Color.White)
                }
            }
        }
    }


}
