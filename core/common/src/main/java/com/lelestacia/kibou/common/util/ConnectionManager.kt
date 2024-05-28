package com.lelestacia.kibou.common.util

interface ConnectionManager {
    fun isOnWifi(): Boolean
    fun isConnectionAvailable(): Boolean
}