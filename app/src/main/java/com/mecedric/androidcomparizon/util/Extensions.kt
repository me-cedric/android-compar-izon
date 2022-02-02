package com.mecedric.androidcomparizon.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.runtime.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController

fun Context.isConnectedToNetwork(context: Context): Boolean {
    val result: Boolean
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val networkCapabilities = connectivityManager?.activeNetwork ?: return false
    val actNw =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    result = when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result
}

fun Context.shortToast(message: String) = Toast.makeText(this, message, LENGTH_SHORT).show()

/**
 * Select a property in an object array and it will be summed
 * @return the sum of selected property
 */
inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

/**
 * Observe a livedata only once.
 * After the first emit the observer is removed.
 */
fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            if (t != null) {
                removeObserver(this)
            }
        }
    })
}

@Composable
fun NavController.AddChangeRouteListener() {
    val localBaseViewModel = LocalBaseViewModel.current
    DisposableEffect(this) {
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            controller.currentDestination?.route?.let { route ->
                localBaseViewModel.setCurrentRoute(route)
            }
        }
        addOnDestinationChangedListener(callback)
        // remove the navController on dispose (i.e. when the composable is destroyed)
        onDispose {
            removeOnDestinationChangedListener(callback)
        }
    }
}