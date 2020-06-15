package dev.aruke.android

import android.app.Application
import dev.aruke.android.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin
import timber.log.Timber

class KickstarterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@KickstarterApp)
            androidFileProperties()
            modules(AppModule())
        }
    }
}