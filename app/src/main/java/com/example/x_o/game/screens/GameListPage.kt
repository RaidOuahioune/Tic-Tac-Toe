package com.example.x_o.game.screens
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.x_o.game.composables.GameItem
import com.example.x_o.game.data.dto.Game
import com.example.x_o.game.network.HttpClient
import okhttp3.ResponseBody.Companion.toResponseBody

class GameListPage {
    @Composable
    operator fun invoke() {
        var data by remember {
            mutableStateOf<List<Game>>(listOf())
        }
        var loading: Boolean by remember {
            mutableStateOf(true)
        }
        Thread(Runnable {
            data = Game.gameFactory(
                HttpClient().fetchGames()?.toResponseBody()?.string() ?: ""
            ) as List<Game>
            loading = false

        }).start()

        if (loading) {
            CircularProgressIndicator(color = Color.Red)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(data) { game ->
                        GameItem(game)()
                    }
                }
            )
        }
    }
}


