package com.example.hscs

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.BuildConfig
import com.example.hscs.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class HscsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@HscsApp)
            modules(
                specialistSignInModule,
                patientSignInModule,
                patientSignUpModule,
                specialistSignUpModule,
                choosingModule
            )
        }

    }
}