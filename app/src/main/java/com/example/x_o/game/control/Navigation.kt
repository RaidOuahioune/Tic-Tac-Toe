package com.example.x_o.game.control

import GamePage
import IntroPage
import TicTacToeViewModel
import android.os.Build
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Navigation(vibrator: Vibrator) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Page.IntroPage.route) {
        composable(
            route = Page.GamePage.route.plus("?ai={ai}"),
            arguments = listOf(
                navArgument("ai") {
                    type = NavType.BoolType
                    defaultValue=false
                }
            )
        ) { navBackStackEntry ->
            val ai = navBackStackEntry.arguments?.getBoolean("ai") as Boolean
            GamePage(vibrator = vibrator).get(viewModel = TicTacToeViewModel(ai))
        }
      composable(Page.IntroPage.route){
          IntroPage(navController).get()
      }
    }
}


