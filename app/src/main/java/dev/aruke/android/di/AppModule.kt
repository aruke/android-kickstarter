package dev.aruke.android.di

import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModule {

    const val KEY_ENVIRONMENT = "environment"

    operator fun invoke() = module {
        single(named(KEY_ENVIRONMENT)) { getProperty<String>(KEY_ENVIRONMENT) }
    }
}