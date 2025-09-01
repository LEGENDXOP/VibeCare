package com.teamx.vibecare.utils

import android.content.Context
import com.teamx.vibecare.auth.utils.TokenStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json

object Ktr{
    const val API_KEY = "https://xflow.live/"
    lateinit var client: HttpClient

    fun init(context: Context){
        client = HttpClient(OkHttp){
            val token = TokenStorage.getAccess(context)
            install(ContentNegotiation){
                json()
            }
            install(DefaultRequest){
                if (token!= null){
                    header(HttpHeaders.Authorization, "Bearer $token")
                }
            }
        }
    }
}