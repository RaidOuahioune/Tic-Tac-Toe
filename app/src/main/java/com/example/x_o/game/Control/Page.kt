package com.example.x_o.game.Control

sealed class Page(public val route:String) {
    object GamePage: Page("game_page")
    object IntroPage:Page("start_page")

}