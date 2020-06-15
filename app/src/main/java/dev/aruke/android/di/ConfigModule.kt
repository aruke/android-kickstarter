package dev.aruke.android.di

import dev.aruke.android.config.Config
import dev.aruke.android.config.Environment
import org.koin.dsl.module
import java.util.*

object ConfigModule {

    operator fun invoke() = module {

        single {

            val environmentString = getProperty<String>("environment").toUpperCase(Locale.US)
            val validEnv = Environment.values().map { it.name }.contains(environmentString)
            if (!validEnv) {
                throw RuntimeException("The key environment in koin.properties must match to a value in ${Environment::class.qualifiedName}")
            }
            val environment = enumValueOf<Environment>(environmentString)

            val baseAPiUrl = getProperty<String>("baseAPiUrl")

            val httpLoggingEnabled = getProperty<String>("httpLoggingEnabled").toBoolean()

            Config(environment, baseAPiUrl, httpLoggingEnabled)
        }
    }
}