package com.lelestacia.kibou.common.util

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

internal class ConnectionManagerImpl(
    connectivityManager: ConnectivityManager,
) : ConnectionManager {

    private val capabilities: NetworkCapabilities? =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

    override fun isOnWifi(): Boolean {
        return capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false
    }

    override fun isConnectionAvailable(): Boolean {
        capabilities?.let {
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

                else -> false
            }

        } ?: return false
    }
}