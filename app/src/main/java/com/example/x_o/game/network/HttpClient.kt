package com.example.x_o.game.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.HttpURLConnection
import java.net.URL


class HttpClient {

    companion object {
        val url = URL("http://192.168.43.147:3000/game")
    }
    fun fetchGames(): String? {
        val urlConnection = url.openConnection() as HttpURLConnection
        val client: OkHttpClient = OkHttpClient();
        val request: Request = Request.Builder()
            .url(url)
            .build();
        try {
            val response: Response = client.newCall(request).execute()
            return response.body?.string()
        } catch (e: Exception) {
            return e.stackTraceToString()
        }
    }
}