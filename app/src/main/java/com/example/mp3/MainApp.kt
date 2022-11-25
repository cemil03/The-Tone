package com.example.mp3

import android.app.Application
import com.example.mp3.di.appModule
import com.example.mp3.di.dataModule
import com.example.mp3.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApp)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }

}