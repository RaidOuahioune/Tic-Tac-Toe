package com.example.x_o.game
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import android.os.Vibrator
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.x_o.game.Control.Navigation
import com.example.x_o.game.states.SplashViewModel
import com.example.x_o.ui.theme.X_oTheme
class MainActivity : ComponentActivity() {


    private val splashModel :SplashViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var vibrator:Vibrator =getSystemService(VIBRATOR_SERVICE) as Vibrator
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                splashModel.isLoading.value
            }
        }
        setContent {
            X_oTheme {
                Navigation(vibrator = vibrator)
            }
        }
    }
}