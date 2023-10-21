package com.example.x_o.game.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.x_o.game.control.Page
import com.example.x_o.game.logic.GameOption


class StartGameButton(
    private val selectedOption: GameOption,
    private val navController: NavController
) {

    @Composable
    operator fun invoke() {
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFfa5552),
                contentColor = Color.White
            ),
            onClick = {
                when (selectedOption) {
                    GameOption.AI -> {
                        // Navigate to the single-player game page
                        navController.navigate(Page.GamePage.route.plus("?ai=true"))
                    }

                    GameOption.MULTIPLAYER -> {
                        // Navigate to the multiplayer game page
                        navController.navigate(Page.GamePage.route)
                    }

                    GameOption.REMOTE -> {
                        // Navigate to the multiplayer game page
                        navController.navigate(Page.GameListPage.route)
                    }
                }
            }
        ) {
            Text(text = "Start Game")
        }
    }

}

