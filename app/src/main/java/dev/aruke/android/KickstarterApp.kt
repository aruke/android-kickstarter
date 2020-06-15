package dev.aruke.android

import android.app.Application
import dev.aruke.android.config.Config
import dev.aruke.android.data.DataModule
import dev.aruke.android.di.AppModule
import dev.aruke.android.di.ConfigModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber

class KickstarterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Load modules in dependency order
        startKoin {

            androidContext(this@KickstarterApp)

            // Load Config
            androidFileProperties()
            modules(ConfigModule())

            // Application module
            modules(AppModule())

            // External modules
            modules(libraryModules())
        }
    }

    private fun libraryModules(): List<Module> = listOf(
        DataModule(
            baseApiUrl = get<Config>().baseAPiUrl,
            enableHttpLogging = get<Config>().httpLoggingEnabled
        )
    )
}