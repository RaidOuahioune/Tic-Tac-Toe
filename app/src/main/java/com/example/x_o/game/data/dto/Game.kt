package com.example.x_o.game.data.dto

import android.util.Log
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Game(var id: Int, val value: GameValue) {
    companion object {
        fun gameFactory(response: String): Any {
            return try {
                Json.decodeFromString<List<Game>>(response)
            } catch (e: Exception) {

                Log.i("decode error", e.message!!.plus(e.stackTraceToString()))
                Game(1, GameValue(listOf(), "", listOf(), ""))
            }
        }
    }
}

