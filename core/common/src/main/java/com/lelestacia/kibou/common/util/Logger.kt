package com.lelestacia.kibou.common.util

import com.lelestacia.kibou.common.Message
import com.lelestacia.kibou.common.Source

interface Logger {
    fun debug(
        source: Source? = null,
        message: Message
    )

    fun error(
        source: Source? = null,
        message: Message
    )

    fun info(
        source: Source? = null,
        message: Message
    )

    fun warning(
        source: Source? = null,
        message: Message
    )
}