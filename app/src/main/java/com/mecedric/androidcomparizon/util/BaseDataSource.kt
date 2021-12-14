package com.mecedric.androidcomparizon.util

import retrofit2.Response
import java.net.SocketTimeoutException

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    /**
     * Get the result of an api call
     * @return a call result body or an error
     */
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): CallResult<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return CallResult.success(body)
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return when (e) {
                is SocketTimeoutException -> error("408 " + (e.message ?: e.toString()))
                else -> error(e.message ?: e.toString())
            }
        }
    }

    /**
     * Generate an error body
     */
    private fun <T> error(message: String): CallResult<T> {
        return CallResult.error("$message | Network call has failed".trim())
    }

}
