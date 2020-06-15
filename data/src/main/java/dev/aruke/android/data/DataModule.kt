package dev.aruke.android.data

import dev.aruke.android.api.ApiModule
import dev.aruke.android.db.DbModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataModule {

    operator fun invoke(
        baseApiUrl: String,
        enableHttpLogging: Boolean
    ) = module {

        // Initialize dependency modules first
        val apiModule = ApiModule(baseApiUrl = baseApiUrl, enableHttpLogging = enableHttpLogging)
        val dbModule = DbModule()

        loadKoinModules(listOf(apiModule, dbModule))

        // Load repositories from here
    }
}