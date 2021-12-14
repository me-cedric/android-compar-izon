package com.mecedric.androidcomparizon.util

/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `LiveData<Result<T>>` to pass back the latest data to the UI with its fetch status.
 */
data class CallResult<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val errorData: Int? = null,
    val errorInfo: List<String>? = null,
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): CallResult<T> = CallResult(Status.SUCCESS, data, null)

        fun <T> error(
            message: String,
            data: T? = null
        ): CallResult<T> = CallResult(Status.ERROR, data, message)

        fun <T> loading(data: T? = null): CallResult<T> = CallResult(Status.LOADING, data, null)
    }
}