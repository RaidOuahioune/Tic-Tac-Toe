package com.example.x_o.game.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.x_o.game.composables.GameModeButton
import com.example.x_o.game.composables.StartGameButton
import com.example.x_o.game.logic.GameOption


class IntroPage(private val navController: NavController) {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    operator fun invoke() {
        var selectedOption by remember { mutableStateOf(GameOption.AI) }
        Scaffold() { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Choose Your Game Mode")
                Column(

                    modifier = Modifier.padding(8.dp).background(color = Color.Transparent),
                    verticalArrangement = Arrangement.Center

                ) {
                    GameModeButton(
                        text = "Play VS AI", selected = selectedOption == GameOption.AI
                    ) {
                        selectedOption = GameOption.AI
                    }()
                    GameModeButton(
                        text = "VS HUMAN", selected = selectedOption == GameOption.MULTIPLAYER
                    ) {
                        selectedOption = GameOption.MULTIPLAYER
                    }()
                    GameModeButton(
                        text = "VS REMOTE HUMAN", selected = selectedOption == GameOption.REMOTE
                    ) {
                        selectedOption = GameOption.REMOTE
                    }()
                }
                StartGameButton(selectedOption = selectedOption, navController = navController)()

            }
        }
    }
}











