package com.example.cryptotrackerapp

import android.app.Application
import com.example.cryptotrackerapp.crypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CryptoTrackerApp :Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CryptoTrackerApp)
            androidLogger()

            modules(appModule)
        }
    }
}