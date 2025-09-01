package com.teamx.vibecare.auth.network

import com.teamx.vibecare.utils.Errors
import kotlinx.serialization.Serializable


enum class AuthErrors: Errors {
    NO_INTERNET,
    INVALID_CREDENTIALS,
    SERVER_ERROR,
    UNKNOWN_ERROR
}
data class ExternalError(val message: String): Errors

@Serializable
data class TokenResponse(
    val access_token: String,
    val refresh_token: String
)

sealed interface Result<out D, out E: Errors>{
    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Failure<out E: Errors>(val error: E): Result<Nothing, E>
}

fun <T, E: Errors, R> Result<T, E>.map(transform: (T) -> R): Result<R, E>{
    return when(this){
        is Result.Success -> Result.Success(transform(data))
        is Result.Failure -> Result.Failure(error)
    }
}

fun <D, E: Errors> Result<D, E>.onSuccess(action: (D) -> Unit): Result<D, E>{
    if (this is Result.Success){
        action(data)
    }
    return this
}

fun <D, E: Errors> Result<D, E>.onFailure(action: (E) -> Unit): Result<D, E>{
    if (this is Result.Failure){
        action(error)
    }
    return this

}