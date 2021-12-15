package com.mecedric.androidcomparizon.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

/**
 * The database serves as the single source of truth.
 * Therefore UI can receive data updates from database only.
 * Function notify UI about:
 * [CallResult.Status.SUCCESS] - with data from database
 * [CallResult.Status.ERROR] - if error has occurred from any source
 * [CallResult.Status.LOADING]
 */
fun <T, A> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: (suspend () -> CallResult<A>)? = null,
    saveCallResult: (suspend (A) -> Unit)? = null
): LiveData<CallResult<T>> =
    liveData(Dispatchers.IO) {
        emit(CallResult.loading())
        val source = databaseQuery.invoke().map { CallResult.success(it) }
        emitSource(source)

        if (networkCall != null) {
            val responseStatus = networkCall.invoke()
            if (responseStatus.status == CallResult.Status.SUCCESS && saveCallResult != null) {
                try {
                    saveCallResult(responseStatus.data!!)
                } catch (err: Error) {
                    emit(CallResult.error(err.message!!))
                }
            } else if (responseStatus.status == CallResult.Status.ERROR) {
                emit(CallResult.error(responseStatus.message!!))
                emitSource(source)
            }
            emit(CallResult.finish())
        }
    }