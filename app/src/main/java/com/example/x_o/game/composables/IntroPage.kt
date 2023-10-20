import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.x_o.game.control.Page
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue


class IntroPage(public val navController: NavController) {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    public fun get() {
        var selectedOption by remember { mutableStateOf(GameOption.AI) }

        Scaffold() { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Choose Your Game Mode")
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GameOptionRadioButton(
                        text = "Play with AI",
                        selected = selectedOption == GameOption.AI
                    ) {
                        selectedOption = GameOption.AI
                    }
                    GameOptionRadioButton(
                        text = "Multiplayer",
                        selected = selectedOption == GameOption.MULTIPLAYER
                    ) {
                        selectedOption = GameOption.MULTIPLAYER
                    }
                }
                Button(
                    modifier = Modifier.width(200.dp).height(50.dp),
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
                        }
                    }
                ) {
                    Text(text = "Start Game")
                }
            }
        }
    }
}

enum class GameOption {
    AI,
    MULTIPLAYER
}

@Composable
fun GameOptionRadioButton(text: String, selected: Boolean, onSelected: () -> Unit) {
    val selection = rememberUpdatedState(selected)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(170.dp)
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
        Text(text)
    }
}







