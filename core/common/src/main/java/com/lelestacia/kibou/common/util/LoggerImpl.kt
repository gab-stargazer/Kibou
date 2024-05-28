package com.lelestacia.kibou.common.util

import com.lelestacia.kibou.common.Message
import com.lelestacia.kibou.common.Source
import timber.log.Timber

internal class LoggerImpl : Logger {

    override fun debug(source: Source?, message: Message) {
        source?.let {
            Timber.d("[DEBUG ${source.className}] ${message.value}")
        } ?: Timber.d("[DEBUG] ${message.value}")
    }

    override fun error(source: Source?, message: Message) {
        source?.let {
            Timber.e("[ERROR ${source.className}] ${message.value}")
        } ?: Timber.e("[ERROR] ${message.value}")
    }

    override fun info(source: Source?, message: Message) {
        source?.let {
            Timber.i("[INFO ${source.className}] ${message.value}")
        } ?: Timber.i("[INFO] ${message.value}")
    }

    override fun warning(source: Source?, message: Message) {
        source?.let {
            Timber.w("[WARNING ${source.className}] ${message.value}")
        } ?: Timber.w("[WARNING] ${message.value}")
    }
}