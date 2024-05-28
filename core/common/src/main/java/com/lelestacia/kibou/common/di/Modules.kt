package com.lelestacia.kibou.common.di

import android.content.Context
import android.net.ConnectivityManager
import com.lelestacia.kibou.common.util.ConnectionManager
import com.lelestacia.kibou.common.util.ConnectionManagerImpl
import com.lelestacia.kibou.common.util.Logger
import com.lelestacia.kibou.common.util.LoggerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val CommonModules = module {

    //  Logger
    singleOf<Logger>(::LoggerImpl) {
        createdAtStart()
    }

    //  Connection Manager
    single<ConnectionManager>(
        createdAtStart = true
    ) {
        ConnectionManagerImpl((androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
    }
}