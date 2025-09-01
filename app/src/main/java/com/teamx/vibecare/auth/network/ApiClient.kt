package com.teamx.vibecare.auth.network

import android.content.Context
import android.os.Build
import androidx.compose.ui.graphics.Path
import com.teamx.vibecare.auth.utils.TokenStorage
import com.teamx.vibecare.utils.Ktr
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlin.collections.mapOf


object ApiClient {
    val client = Ktr.client

    suspend inline fun <reified Response> refreshCall(
        context: Context,
        crossinline originalCall: suspend () -> Result<Response, AuthErrors>
    ): Result<Response, AuthErrors>{
        val response = originalCall()
        return when(response){
            is Result.Success -> response
            is Result.Failure -> {
                if (response.error == AuthErrors.INVALID_CREDENTIALS){
                    if (refreshTokens(context)){
                        val retry = originalCall()
                        retry
                    }else{
                        response
                    }
                }
                response
            }
        }
    }

    suspend inline fun <reified Response> get(
        route: String,
        queryParameters: Map<String, Any?> = emptyMap()
    ): Result<Response, AuthErrors>{
        return safeCall {
            client.get {
                url(route)
                queryParameters.forEach { (key, value) ->
                    parameter(key, value)
                }
            }
        }
    }

    suspend inline fun <reified Request, reified Response: Any> post(
        route: String,
        body: Request
    ): Result<Response, AuthErrors>{
        return safeCall {
            client.post{
                url(route)
                setBody(body)
                contentType(ContentType.Application.Json)
            }
        }
    }

    suspend inline fun <reified T> safeCall(
        execute: suspend () -> HttpResponse
    ): Result<T, AuthErrors>{
        return try {
            responseToResult(execute())
        }catch (e: Exception){
            Result.Failure(AuthErrors.NO_INTERNET)
        }
    }

    suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, AuthErrors>{
        return when (response.status.value){
            in 200..299 -> Result.Success(response.body())
            401 -> Result.Failure(AuthErrors.INVALID_CREDENTIALS)
            in 400..499 -> Result.Failure(AuthErrors.UNKNOWN_ERROR)
            in 500..599 -> Result.Failure(AuthErrors.SERVER_ERROR)
            else -> Result.Failure(AuthErrors.UNKNOWN_ERROR)
        }
    }

    suspend fun refreshTokens(context: Context): Boolean{
        val refresh = TokenStorage.getRefresh(context) ?: return false
        val response: Result<TokenResponse, AuthErrors> = post(
            Ktr.API_KEY + "refresh",
            mapOf("refresh_token" to refresh, "device_id" to Build.MODEL)
        )
        if (response is Result.Success){
            val access = response.data.access_token
            val refreshToken = response.data.refresh_token
            TokenStorage.saveTokens(context, access, refreshToken)
            return true
        }
        return false
    }
}