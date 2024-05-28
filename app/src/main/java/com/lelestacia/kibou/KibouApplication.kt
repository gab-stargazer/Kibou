package com.lelestacia.kibou

import android.app.Application
import com.lelestacia.kibou.common.di.CommonModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class KibouApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KibouApplication)
            modules(CommonModules)
        }
        Timber.plant(Timber.DebugTree())
    }
}