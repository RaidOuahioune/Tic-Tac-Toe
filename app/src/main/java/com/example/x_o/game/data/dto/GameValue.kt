package com.example.x_o.game.data.dto

import kotlinx.serialization.Serializable


@Serializable
class GameValue(
    public val clients: List<String?>,
    public val winner: String?,
    public val state: List<String>,
    public val password: String?
) {


}